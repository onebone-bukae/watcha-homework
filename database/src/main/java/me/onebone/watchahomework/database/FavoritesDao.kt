package me.onebone.watchahomework.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritesDao {
	@Insert
	suspend fun insert(track: TrackEntity)

	@Delete
	suspend fun delete(track: TrackEntity)

	@Query("""SELECT * FROM TrackEntity WHERE
		 	trackName = :trackName 
			AND artistName = :artistName 
			AND collectionName = :collectionName""")
	suspend fun one(
		trackName: String,
		artistName: String,
		collectionName: String
	): TrackEntity?
}

suspend fun FavoritesDao.exists(track: TrackEntity): Boolean =
	one(track.trackName, track.artistName, track.collectionName) != null
