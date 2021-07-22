package me.onebone.watchahomework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TrackEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
	abstract fun favoritesDao(): FavoritesDao

	companion object {
		private const val DatabaseName = "favorites-db"

		fun build(context: Context): AppDatabase =
			Room.databaseBuilder(context, AppDatabase::class.java, DatabaseName).build()
	}
}
