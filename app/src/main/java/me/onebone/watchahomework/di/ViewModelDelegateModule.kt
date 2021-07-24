package me.onebone.watchahomework.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.onebone.watchahomework.ui.favorites.FavoritesViewModelDelegate
import me.onebone.watchahomework.ui.favorites.FavoritesViewModelDelegateImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelDelegateModule {
	@Binds
	@Singleton
	abstract fun bindFavoritesViewModelDelegate(
		impl: FavoritesViewModelDelegateImpl
	): FavoritesViewModelDelegate
}
