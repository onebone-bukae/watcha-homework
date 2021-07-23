package me.onebone.watchahomework.shared.repository

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.data.FavoritesDataSource
import javax.inject.Inject

interface FavoritesRepository {
	suspend fun isFavorite(track: Track): Boolean

	suspend fun addFavorite(track: Track)
}

class FavoritesRepositoryImpl @Inject constructor(
	private val source: FavoritesDataSource
): FavoritesRepository {
	override suspend fun isFavorite(track: Track): Boolean =
		source.isFavorite(track)

	override suspend fun addFavorite(track: Track) =
		source.addFavorite(track)
}
