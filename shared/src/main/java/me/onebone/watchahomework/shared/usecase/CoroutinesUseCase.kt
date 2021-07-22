package me.onebone.watchahomework.shared.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class CoroutinesUseCase<T> {
	suspend operator fun invoke(): Result<T> = withContext(Dispatchers.IO) {
		runCatching {
			execute()
		}
	}

	abstract suspend fun execute(): T
}
