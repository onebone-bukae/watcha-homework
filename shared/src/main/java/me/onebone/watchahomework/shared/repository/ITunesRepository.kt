package me.onebone.watchahomework.shared.repository

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.data.ITunesDataSource
import javax.inject.Inject

interface ITunesRepository {
	suspend fun getTracks(offset: Int, limit: Int): List<Track>
}

class ITunesRepositoryImpl @Inject constructor(
	private val iTunesDataSource: ITunesDataSource
): ITunesRepository {
	override suspend fun getTracks(offset: Int, limit: Int): List<Track> =
		iTunesDataSource.getTracks(offset, limit)
}
