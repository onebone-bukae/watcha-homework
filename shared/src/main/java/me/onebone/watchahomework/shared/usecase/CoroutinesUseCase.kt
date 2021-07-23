package me.onebone.watchahomework.shared.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class CoroutinesUseCase<P, R> {
	suspend operator fun invoke(value: P): Result<R> = withContext(Dispatchers.IO) {
		runCatching {
			execute(value)
		}
	}

	internal abstract suspend fun execute(value: P): R
}
