package me.onebone.watchahomework.shared.data

import me.onebone.watchahomework.model.Track
import javax.inject.Inject

interface ITunesDataSource {
	suspend fun getTracks(): List<Track>
}

class NetworkITunesDataSource @Inject constructor(): ITunesDataSource {
	override suspend fun getTracks(): List<Track> {
		TODO("Not yet implemented")
	}
}
