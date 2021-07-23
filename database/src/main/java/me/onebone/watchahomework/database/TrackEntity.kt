package me.onebone.watchahomework.database

import androidx.room.Entity

@Entity(primaryKeys = ["trackName", "artistName", "collectionName"])
data class TrackEntity(
	val trackName: String,
	val artistName: String,
	val artworkUrl: String?,
	val collectionName: String
)
