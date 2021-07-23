package me.onebone.watchahomework.shared.util

import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.model.Track

fun Track.toEntity() =
	TrackEntity(
		trackName = trackName, artistName = artistName,
		artworkUrl = artworkUrl60, collectionName = collectionName
	)
