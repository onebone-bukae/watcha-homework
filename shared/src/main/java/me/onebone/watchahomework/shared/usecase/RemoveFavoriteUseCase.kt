package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.model.Track
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
	private val repository: FavoritesRepository
): CoroutinesUseCase<Track, Unit>() {
	override suspend fun execute(value: Track) =
		repository.removeFavorite(value)
}
