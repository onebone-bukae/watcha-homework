package me.onebone.watchahomework.shared.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.usecase.GetTrackUseCase
import javax.inject.Inject

class TracksPagingSource @Inject constructor(
	private val getTrackUseCase: GetTrackUseCase
): PagingSource<Int, Track>() {
	override fun getRefreshKey(state: PagingState<Int, Track>): Int? =
		state.anchorPosition

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Track> {
		val offset = params.key ?: 0
		val limit = params.loadSize

		val result = getTrackUseCase.invoke(GetTrackUseCase.PageData(offset, limit))

		val exception = result.exceptionOrNull()
		if(exception != null) return LoadResult.Error(exception)

		val tracks = result.getOrThrow() // Result is not Error, there should exist a value
		return LoadResult.Page(
			data = tracks,
			prevKey = null,
			// confirmation required: end of page if the list is smaller than the requested limit?
			nextKey = if(tracks.size < limit) null else offset + limit,
		)
	}
}
