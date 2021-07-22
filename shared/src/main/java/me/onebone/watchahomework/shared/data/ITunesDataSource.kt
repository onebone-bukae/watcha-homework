package me.onebone.watchahomework.shared.data

import me.onebone.watchahomework.model.Track
import javax.inject.Inject

interface ITunesDataSource {
	suspend fun getTracks(): List<Track>
}

class NetworkITunesDataSource @Inject constructor(
	private val service: ITunesService
): ITunesDataSource {
	override suspend fun getTracks(): List<Track> {
		// search using default query parameters
		val response = service.search()

		return response.results
	}
}
