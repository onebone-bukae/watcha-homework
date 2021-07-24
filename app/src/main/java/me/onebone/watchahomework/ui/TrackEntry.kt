package me.onebone.watchahomework.ui

import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.TracksPagingSource

data class TrackEntry(
	val trackName: String,
	val collectionName: String,
	val artistName: String,
	val artworkUrl: String?,
	var isFavorite: Boolean
)

fun TrackEntry.toEntity() =
	TrackEntity(
		trackName = trackName, collectionName = collectionName,
		artistName = artistName, artworkUrl = artworkUrl
	)

fun TrackEntity.toEntry(isFavorite: Boolean) =
	TrackEntry(
		trackName = trackName, collectionName = collectionName, artistName = artistName,
		artworkUrl = artworkUrl, isFavorite = isFavorite
	)
