package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import javax.inject.Inject

class IsFavoriteUseCase @Inject constructor(
	private val favoritesRepository: FavoritesRepository
): CoroutinesUseCase<TrackEntity, Boolean>() {
	override suspend fun execute(value: TrackEntity): Boolean =
		favoritesRepository.isFavorite(value)
}
