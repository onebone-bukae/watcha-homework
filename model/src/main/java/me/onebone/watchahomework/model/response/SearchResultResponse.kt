package me.onebone.watchahomework.model.response

import kotlinx.serialization.Serializable
import me.onebone.watchahomework.model.Track

@Serializable
data class SearchResultResponse(
	val resultCount: Int,
	val results: List<Track>
)
