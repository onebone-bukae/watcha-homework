package me.onebone.watchahomework.shared.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.onebone.watchahomework.database.TrackEntity
import javax.inject.Inject

class FavoritesPagingSource @Inject constructor(
	repository: FavoritesRepository
): PagingSource<Int, TrackEntity>() {
	private val source by lazy { repository.getAllPaged() }

	override fun getRefreshKey(state: PagingState<Int, TrackEntity>): Int? =
		source.getRefreshKey(state)

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TrackEntity> =
		source.load(params)
}

fun interface FavoritesPagingSourceFactory {
	fun create(): PagingSource<Int, TrackEntity>
}

class FavoritesPagingSourceFactoryImpl @Inject constructor(
	private val repository: FavoritesRepository
): FavoritesPagingSourceFactory {
	override fun create(): PagingSource<Int, TrackEntity> {
		return FavoritesPagingSource(repository)
	}
}
