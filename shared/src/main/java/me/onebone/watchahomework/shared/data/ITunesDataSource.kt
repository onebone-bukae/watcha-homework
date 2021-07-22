package me.onebone.watchahomework.shared.data

import me.onebone.watchahomework.model.Track
import javax.inject.Inject

interface ITunesDataSource {
	suspend fun getTracks(offset: Int, limit: Int): List<Track>
}

class NetworkITunesDataSource @Inject constructor(
	private val service: ITunesService
): ITunesDataSource {
	override suspend fun getTracks(offset: Int, limit: Int): List<Track> {
		val response = service.search(offset = offset, limit = limit)

		return response.results
	}
}
