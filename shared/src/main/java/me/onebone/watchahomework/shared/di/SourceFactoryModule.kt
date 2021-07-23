package me.onebone.watchahomework.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.onebone.watchahomework.shared.repository.FavoritesPagingSourceFactory
import me.onebone.watchahomework.shared.repository.FavoritesPagingSourceFactoryImpl
import me.onebone.watchahomework.shared.repository.TracksPagingSourceFactory
import me.onebone.watchahomework.shared.repository.TracksPagingSourceFactoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceFactoryModule {
	@Binds
	@Singleton
	abstract fun bindFavoritesPagingSourceFactory(
		impl: FavoritesPagingSourceFactoryImpl
	): FavoritesPagingSourceFactory

	@Binds
	@Singleton
	abstract fun bindTracksSourcePagingFactory(
		impl: TracksPagingSourceFactoryImpl
	): TracksPagingSourceFactory
}
