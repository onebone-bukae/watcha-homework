package me.onebone.watchahomework.shared.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.usecase.GetTrackUseCase
import me.onebone.watchahomework.shared.usecase.IsFavoriteUseCase
import me.onebone.watchahomework.shared.util.toEntity
import javax.inject.Inject

class TracksPagingSource @Inject constructor(
	private val getTrackUseCase: GetTrackUseCase,
	private val isFavoriteUseCase: IsFavoriteUseCase
): PagingSource<Int, TracksPagingSource.TrackAndFavorite>() {
	override fun getRefreshKey(state: PagingState<Int, TrackAndFavorite>): Int? =
		state.anchorPosition

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TrackAndFavorite> {
		val offset = params.key ?: 0
		val limit = params.loadSize

		val result = getTrackUseCase.invoke(GetTrackUseCase.PageData(offset, limit))

		val tracks = result.getOrElse { return LoadResult.Error(it) }

		val composite = runCatching {
			coroutineScope {
				tracks.map {
					async {
						val isFavoriteResult = isFavoriteUseCase.invoke(it.toEntity())

						TrackAndFavorite(
							track = it.toEntity(),
							isFavorite = isFavoriteResult.getOrThrow()
						)
					}
				}
			}
		}.getOrElse { return LoadResult.Error(it) }

		return LoadResult.Page(
			data = composite.awaitAll(),
			// is this right prevKey?
			prevKey = (offset - limit)
				.coerceAtLeast(0)
				.takeIf {
					it < offset
				},
			// confirmation required: end of page if the list is smaller than the requested limit?
			nextKey = if(tracks.size < limit) null else offset + tracks.size,
			itemsBefore = offset,
		)
	}

	data class TrackAndFavorite(
		val track: TrackEntity,
		// PagingDataAdapter does not allow us to replace list entry instance,
		// we should mark this as a mutable field to make the change visible to the user.
		// Consider using observable read query provided by Room.
		var isFavorite: Boolean
	)
}
