package me.onebone.watchahomework.ui.tracks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.TracksPagingSourceFactory
import me.onebone.watchahomework.shared.usecase.AddFavoriteUseCase
import me.onebone.watchahomework.shared.usecase.IsFavoriteUseCase
import me.onebone.watchahomework.shared.usecase.RemoveFavoriteUseCase
import me.onebone.watchahomework.shared.util.toEntity
import me.onebone.watchahomework.ui.TrackEntry
import me.onebone.watchahomework.ui.favorites.FavoritesChangeSource
import me.onebone.watchahomework.ui.favorites.FavoritesViewModelDelegate
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel @Inject constructor(
	private val pagingSourceFactory: TracksPagingSourceFactory,
	private val addFavoriteUseCase: AddFavoriteUseCase,
	private val removeFavoriteUseCase: RemoveFavoriteUseCase,
	private val isFavoriteUseCase: IsFavoriteUseCase,
	favoritesViewModelDelegate: FavoritesViewModelDelegate
): ViewModel(), FavoritesViewModelDelegate by favoritesViewModelDelegate {
	private val _tracks = Pager(
		config = PagingConfig(
			pageSize = 30, enablePlaceholders = false, initialLoadSize = 30
		),
		pagingSourceFactory = {
			pagingSourceFactory.create()
		}
	).flow.cachedIn(viewModelScope)

	private val _trackEntries = MutableSharedFlow<Flow<PagingData<TrackEntry>>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
	val trackEntries: SharedFlow<Flow<PagingData<TrackEntry>>> = _trackEntries

	init {
		viewModelScope.launch {
			refreshFavorites()

			favoritesChangeFlow.collect {
				if(it == FavoritesChangeSource.TrackList) return@collect

				refreshFavorites()
			}
		}
	}

	private suspend fun refreshFavorites() {
		_trackEntries.emit(_tracks.map { data ->
			data.map {
				// TODO confirm the behavior when favorite flag cannot be fetched
				// do I want it to throw really???
				val isFavorite = isFavoriteUseCase(it.toEntity()).getOrThrow()

				TrackEntry(
					trackName = it.trackName, collectionName = it.collectionName,
					artistName = it.artistName, artworkUrl = it.artworkUrl60,
					isFavorite = isFavorite
				)
			}
		})
	}

	fun addFavorite(track: TrackEntity) {
		// FIXME what if viewModelScope cancels before the use case completes its job?
		viewModelScope.launch {
			addFavoriteUseCase(track)
			emitFavoriteChangeEvent(FavoritesChangeSource.TrackList)
		}
	}

	fun removeFavorite(track: TrackEntity) {
		viewModelScope.launch {
			removeFavoriteUseCase(track)
			emitFavoriteChangeEvent(FavoritesChangeSource.TrackList)
		}
	}
}
