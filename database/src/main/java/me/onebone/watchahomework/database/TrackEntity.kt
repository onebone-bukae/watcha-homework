package me.onebone.watchahomework.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrackEntity(
	@PrimaryKey(autoGenerate = true) val id: Int? = null,
	val trackName: String,
	val artistName: String,
	val localArtworkPath: String?,
	val collectionName: String
)
