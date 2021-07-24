package me.onebone.watchahomework.shared.data

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.serialization.responseObject
import com.github.kittinunf.result.Result as FuelResult
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.json.Json
import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.model.response.SearchResultResponse
import me.onebone.watchahomework.shared.BuildConfig
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface ITunesDataSource {
	suspend fun getTracks(offset: Int, limit: Int): List<Track>
}

class FuelITunesDataSource @Inject constructor(
	private val json: Json
): ITunesDataSource {
	override suspend fun getTracks(offset: Int, limit: Int): List<Track> = suspendCancellableCoroutine { continuation ->
		val request = Fuel.get(
			path = "${BuildConfig.ITUNES_API_BASE_URL}/search",
			parameters = listOf(
				"offset" to offset, "limit" to limit,
				"term" to "greenday", "entity" to "song"
			)
		).responseObject<SearchResultResponse>(json) { _, _, result ->
			when(result) {
				is FuelResult.Success ->
					continuation.resume(result.value.results)
				is FuelResult.Failure ->
					continuation.resumeWithException(result.getException())
			}
		}

		continuation.invokeOnCancellation {
			request.cancel()
		}
	}
}
