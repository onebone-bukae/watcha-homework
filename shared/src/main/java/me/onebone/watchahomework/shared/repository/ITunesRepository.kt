package me.onebone.watchahomework.shared.repository

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.data.ITunesDataSource
import javax.inject.Inject

interface ITunesRepository {
	suspend fun getTracks(): List<Track>
}

class ITunesRepositoryImpl @Inject constructor(
	private val iTunesDataSource: ITunesDataSource
): ITunesRepository {
	override suspend fun getTracks(): List<Track> =
		iTunesDataSource.getTracks()
}
