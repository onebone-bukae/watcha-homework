package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.repository.ITunesRepository
import javax.inject.Inject

class GetTrackUseCase @Inject constructor(
	private val repository: ITunesRepository
): CoroutinesUseCase<List<Track>>() {
	override suspend fun execute(): List<Track> =
		repository.getTracks()
}
