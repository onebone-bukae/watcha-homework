package me.onebone.watchahomework.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.onebone.watchahomework.shared.repository.FavoritesPagingSourceFactory
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
	pagingSourceFactory: FavoritesPagingSourceFactory
): ViewModel() {
	val favorites = Pager(
		config = PagingConfig(pageSize = 30, enablePlaceholders = false),
		pagingSourceFactory = {
			pagingSourceFactory.create()
		}
	).flow.cachedIn(viewModelScope)
}
