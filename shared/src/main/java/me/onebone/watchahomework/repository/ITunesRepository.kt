package me.onebone.watchahomework.repository

import me.onebone.watchahomework.model.Track

interface ITunesRepository {
	suspend fun getTracks(): List<Track>
}

class ITunesRepositoryImpl: ITunesRepository {
	override suspend fun getTracks(): List<Track> {
		TODO("Not yet implemented")
	}
}
