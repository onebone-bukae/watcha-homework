package me.onebone.watchahomework.shared.repository

import androidx.paging.PagingSource
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.data.FavoritesDataSource
import javax.inject.Inject

interface FavoritesRepository {
	suspend fun isFavorite(track: TrackEntity): Boolean

	suspend fun addFavorite(track: TrackEntity)

	suspend fun removeFavorite(track: TrackEntity)

	fun getAllPaged(): PagingSource<Int, TrackEntity>
}

class FavoritesRepositoryImpl @Inject constructor(
	private val source: FavoritesDataSource
): FavoritesRepository {
	override suspend fun isFavorite(track: TrackEntity): Boolean =
		source.isFavorite(track)

	override suspend fun addFavorite(track: TrackEntity) =
		source.addFavorite(track)

	override suspend fun removeFavorite(track: TrackEntity) =
		source.removeFavorite(track)

	override fun getAllPaged(): PagingSource<Int, TrackEntity> =
		source.getAllPaged()
}
