package me.onebone.watchahomework.shared.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import me.onebone.watchahomework.shared.data.FavoritesDataSource
import me.onebone.watchahomework.shared.data.FuelITunesDataSource
import me.onebone.watchahomework.shared.data.ITunesDataSource
import me.onebone.watchahomework.shared.data.RoomFavoritesDataSource
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import me.onebone.watchahomework.shared.repository.FavoritesRepositoryImpl
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
	abstract fun bindITunesDataSource(dataSource: FuelITunesDataSource): ITunesDataSource

	@Binds
	@Singleton
	abstract fun bindITunesRepository(repository: ITunesRepositoryImpl): ITunesRepository

	@Binds
	@Singleton
	abstract fun bindFavoritesDataSource(dataSource: RoomFavoritesDataSource): FavoritesDataSource

	@Binds
	@Singleton
	abstract fun bindFavoritesRepository(repository: FavoritesRepositoryImpl): FavoritesRepository
}
