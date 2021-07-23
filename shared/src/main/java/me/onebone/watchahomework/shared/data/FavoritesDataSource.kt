package me.onebone.watchahomework.shared.data

import me.onebone.watchahomework.database.FavoritesDao
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.database.exists
import me.onebone.watchahomework.model.Track
import javax.inject.Inject

interface FavoritesDataSource {
	suspend fun isFavorite(track: Track): Boolean

	suspend fun addFavorite(track: Track)
}

class RoomFavoritesDataSource @Inject constructor(
	private val favoritesDao: FavoritesDao
): FavoritesDataSource {
	override suspend fun isFavorite(track: Track): Boolean {
		return favoritesDao.exists(track.toEntity())
	}

	override suspend fun addFavorite(track: Track) {
		favoritesDao.insert(track.toEntity())
	}
}

internal fun Track.toEntity() = TrackEntity(
	trackName = trackName, artistName = artistName,
	artworkUrl = artworkUrl100, collectionName = collectionName
)
