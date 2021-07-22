package me.onebone.watchahomework.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface FavoritesDao {
	@Insert
	suspend fun insert(track: TrackEntity)

	@Delete
	suspend fun delete(track: TrackEntity)
}
