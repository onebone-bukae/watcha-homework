package me.onebone.watchahomework.shared.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import me.onebone.watchahomework.shared.data.ITunesDataSource
import me.onebone.watchahomework.shared.data.NetworkITunesDataSource
import me.onebone.watchahomework.shared.repository.ITunesRepository
import me.onebone.watchahomework.shared.repository.ITunesRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
	@Provides
	@Singleton
	fun provideJson(): Json =
		Json { ignoreUnknownKeys = true }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkBindsModule {
	@Binds
	@Singleton
	abstract fun bindsITunesDataSource(dataSource: NetworkITunesDataSource): ITunesDataSource

	@Binds
	@Singleton
	abstract fun bindsITunesRepository(repository: ITunesRepositoryImpl): ITunesRepository
}
