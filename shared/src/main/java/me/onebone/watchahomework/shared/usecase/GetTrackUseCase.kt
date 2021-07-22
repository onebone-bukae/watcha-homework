package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.repository.ITunesRepository
import javax.inject.Inject

class GetTrackUseCase @Inject constructor(
	private val repository: ITunesRepository
): CoroutinesUseCase<GetTrackUseCase.PageData, List<Track>>() {
	override suspend fun execute(value: PageData): List<Track> =
		repository.getTracks(value.offset, value.limit)

	data class PageData(val offset: Int, val limit: Int)
}
