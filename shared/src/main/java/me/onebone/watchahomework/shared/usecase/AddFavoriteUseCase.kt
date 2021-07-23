package me.onebone.watchahomework.shared.usecase

import me.onebone.watchahomework.database.TrackEntity
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import javax.inject.Inject

class AddFavoriteUseCase @Inject constructor(
	private val repository: FavoritesRepository
): CoroutinesUseCase<TrackEntity, Unit>() {
	override suspend fun execute(value: TrackEntity) =
		repository.addFavorite(value)
}
