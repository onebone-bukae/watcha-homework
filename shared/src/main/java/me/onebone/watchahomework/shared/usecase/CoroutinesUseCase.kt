package me.onebone.watchahomework.shared.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class CoroutinesUseCase<P, T> {
	suspend operator fun invoke(value: P): Result<T> = withContext(Dispatchers.IO) {
		runCatching {
			execute(value)
		}
	}

	abstract suspend fun execute(value: P): T
}
