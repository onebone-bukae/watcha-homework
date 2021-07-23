package me.onebone.watchahomework.ui.tracks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.TracksPagingSourceFactory
import me.onebone.watchahomework.shared.usecase.AddFavoriteUseCase
import me.onebone.watchahomework.shared.usecase.RemoveFavoriteUseCase
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel @Inject constructor(
	private val pagingSourceFactory: TracksPagingSourceFactory,
	private val addFavoriteUseCase: AddFavoriteUseCase,
	private val removeFavoriteUseCase: RemoveFavoriteUseCase
): ViewModel() {
	val tracks = Pager(
		config = PagingConfig(
			pageSize = 30, enablePlaceholders = false, initialLoadSize = 30
		),
		pagingSourceFactory = {
			pagingSourceFactory.create()
		}
	).flow.cachedIn(viewModelScope)

	fun addFavorite(track: TrackEntity) {
		// FIXME what if viewModelScope cancels before the use case completes its job?
		viewModelScope.launch {
			addFavoriteUseCase(track)
		}
	}

	fun removeFavorite(track: TrackEntity) {
		viewModelScope.launch {
			removeFavoriteUseCase(track)
		}
	}
}
