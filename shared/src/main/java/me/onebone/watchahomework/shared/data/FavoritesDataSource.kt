package me.onebone.watchahomework.shared.data

import androidx.paging.PagingSource
import me.onebone.watchahomework.database.FavoritesDao
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.database.exists
import me.onebone.watchahomework.model.Track
import javax.inject.Inject

interface FavoritesDataSource {
	suspend fun isFavorite(track: Track): Boolean

	suspend fun addFavorite(track: Track)

	suspend fun removeFavorite(track: Track)

	fun getAllPaged(): PagingSource<Int, TrackEntity>
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

	override suspend fun removeFavorite(track: Track) {
		favoritesDao.delete(track.toEntity())
	}

	override fun getAllPaged(): PagingSource<Int, TrackEntity> {
		return favoritesDao.pagedAll()
	}
}

internal fun Track.toEntity() = TrackEntity(
	trackName = trackName, artistName = artistName,
	artworkUrl = artworkUrl100, collectionName = collectionName
)
