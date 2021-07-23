package me.onebone.watchahomework.ui.tracks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.repository.TracksPagingSource
import me.onebone.watchahomework.shared.usecase.AddFavoriteUseCase
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel @Inject constructor(
	private val pagingSource: TracksPagingSource,
	private val addFavoriteUseCase: AddFavoriteUseCase
): ViewModel() {
	val tracks = Pager(
		config = PagingConfig(
			pageSize = 30, enablePlaceholders = false, initialLoadSize = 30
		),
		pagingSourceFactory = {
			pagingSource
		}
	).flow.cachedIn(viewModelScope)

	fun addFavorite(track: Track) {
		viewModelScope.launch {
			addFavoriteUseCase(track)
		}
	}
}
