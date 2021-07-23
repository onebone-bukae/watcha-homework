package me.onebone.watchahomework.shared.data

import androidx.paging.PagingSource
import me.onebone.watchahomework.database.FavoritesDao
import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.database.exists
import javax.inject.Inject

interface FavoritesDataSource {
	suspend fun isFavorite(track: TrackEntity): Boolean

	suspend fun addFavorite(track: TrackEntity)

	suspend fun removeFavorite(track: TrackEntity)

	fun getAllPaged(): PagingSource<Int, TrackEntity>
}

class RoomFavoritesDataSource @Inject constructor(
	private val favoritesDao: FavoritesDao
): FavoritesDataSource {
	override suspend fun isFavorite(track: TrackEntity): Boolean {
		return favoritesDao.exists(track)
	}

	override suspend fun addFavorite(track: TrackEntity) {
		favoritesDao.insert(track)
	}

	override suspend fun removeFavorite(track: TrackEntity) {
		favoritesDao.delete(track)
	}

	override fun getAllPaged(): PagingSource<Int, TrackEntity> {
		return favoritesDao.pagedAll()
	}
}
