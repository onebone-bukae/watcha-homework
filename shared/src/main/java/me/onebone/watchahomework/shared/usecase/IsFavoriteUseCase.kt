package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import javax.inject.Inject

class IsFavoriteUseCase @Inject constructor(
	private val favoritesRepository: FavoritesRepository
): CoroutinesUseCase<Track, Boolean>() {
	override suspend fun execute(value: Track): Boolean =
		favoritesRepository.isFavorite(value)
}
