package me.onebone.watchahomework.shared.repository

import androidx.paging.PagingSource
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.data.FavoritesDataSource
import javax.inject.Inject

interface FavoritesRepository {
	suspend fun isFavorite(track: Track): Boolean

	suspend fun addFavorite(track: Track)

	suspend fun removeFavorite(track: Track)

	fun getAllPaged(): PagingSource<Int, TrackEntity>
}

class FavoritesRepositoryImpl @Inject constructor(
	private val source: FavoritesDataSource
): FavoritesRepository {
	override suspend fun isFavorite(track: Track): Boolean =
		source.isFavorite(track)

	override suspend fun addFavorite(track: Track) =
		source.addFavorite(track)

	override suspend fun removeFavorite(track: Track) =
		source.removeFavorite(track)

	override fun getAllPaged(): PagingSource<Int, TrackEntity> =
		source.getAllPaged()
}
