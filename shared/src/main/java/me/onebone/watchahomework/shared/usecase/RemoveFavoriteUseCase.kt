package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
	private val repository: FavoritesRepository
): CoroutinesUseCase<TrackEntity, Unit>() {
	override suspend fun execute(value: TrackEntity) =
		repository.removeFavorite(value)
}
