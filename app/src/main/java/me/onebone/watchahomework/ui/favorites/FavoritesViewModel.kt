package me.onebone.watchahomework.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.FavoritesPagingSourceFactory
import me.onebone.watchahomework.shared.usecase.RemoveFavoriteUseCase
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
	pagingSourceFactory: FavoritesPagingSourceFactory,
	private val removeFavoriteUseCase: RemoveFavoriteUseCase,
	favoritesViewModelDelegate: FavoritesViewModelDelegate
): ViewModel(), FavoritesViewModelDelegate by favoritesViewModelDelegate {
	val favorites = Pager(
		config = PagingConfig(pageSize = 30, enablePlaceholders = false),
		pagingSourceFactory = {
			pagingSourceFactory.create()
		}
	).flow.cachedIn(viewModelScope)

	fun removeFavorite(entity: TrackEntity) {
		viewModelScope.launch {
			removeFavoriteUseCase(entity)
			emitFavoriteChangeEvent(FavoritesChangeSource.FavoritesList)
		}
	}
}
