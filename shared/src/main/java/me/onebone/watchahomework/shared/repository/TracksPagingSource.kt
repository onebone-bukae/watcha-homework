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

		val tracks = result.getOrElse { return LoadResult.Error(it) }

		return LoadResult.Page(
			data = tracks,
			// is this right prevKey?
			prevKey = (offset - limit)
				.coerceAtLeast(0)
				.takeIf {
					it < offset
				},
			// confirmation required: end of page if the list is smaller than the requested limit?
			nextKey = if(tracks.size < limit) null else offset + tracks.size
		)
	}
}
