package me.onebone.watchahomework.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.onebone.watchahomework.shared.repository.FavoritesPagingSourceFactory
import me.onebone.watchahomework.shared.repository.FavoritesPagingSourceFactoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoritesModule {
	@Binds
	abstract fun favoritesPagingSourceFactory(
		impl: FavoritesPagingSourceFactoryImpl
	): FavoritesPagingSourceFactory
}
