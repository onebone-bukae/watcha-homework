package me.onebone.watchahomework.shared.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.onebone.watchahomework.shared.repository.ITunesRepository
import me.onebone.watchahomework.shared.usecase.GetTrackUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
	@Provides
	@Singleton
	fun provideGetTrackUseCase(repository: ITunesRepository) =
		GetTrackUseCase(repository)
}
