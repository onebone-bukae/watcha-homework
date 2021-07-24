package me.onebone.watchahomework.ui.favorites

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

/**
 * Interface for the view models which implement favorite list
 */
interface FavoritesViewModelDelegate {
	val favoritesChangeFlow: Flow<Unit>

	fun emitFavoriteChangeEvent()
}

class FavoritesViewModelDelegateImpl @Inject constructor(): FavoritesViewModelDelegate {
	private val _favoritesChangeFlow = MutableSharedFlow<Unit>(
		// we should not set positive replay value, because this flow emits an event
		// which is not desirable to be processed more than once.
		extraBufferCapacity = 1,
		onBufferOverflow = BufferOverflow.DROP_OLDEST
	)
	override val favoritesChangeFlow: Flow<Unit> = _favoritesChangeFlow

	override fun emitFavoriteChangeEvent() {
		_favoritesChangeFlow.tryEmit(Unit)
	}
}
