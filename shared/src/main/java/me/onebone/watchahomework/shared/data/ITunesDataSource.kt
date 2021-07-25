package me.onebone.watchahomework.shared.data

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Deserializable
import com.github.kittinunf.fuel.core.awaitResponse
import com.github.kittinunf.fuel.serialization.kotlinxDeserializerOf
import kotlinx.serialization.json.Json
import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.model.response.SearchResultResponse
import me.onebone.watchahomework.shared.BuildConfig
import javax.inject.Inject

interface ITunesDataSource {
	suspend fun getTracks(offset: Int, limit: Int): List<Track>
}

class FuelITunesDataSource @Inject constructor(
	private val json: Json
): ITunesDataSource {
	override suspend fun getTracks(offset: Int, limit: Int): List<Track> {
		val (_, _, data) = Fuel.get(
			path = "${BuildConfig.ITUNES_API_BASE_URL}/search",
			parameters = listOf(
				"offset" to offset, "limit" to limit,
				"term" to "greenday", "entity" to "song"
			)
		).awaitResponse<SearchResultResponse, Deserializable<SearchResultResponse>>(kotlinxDeserializerOf(json))

		return data.results
	}
}
