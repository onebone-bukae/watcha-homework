package me.onebone.watchahomework.shared.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.onebone.watchahomework.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
	@Provides
	@Singleton
	fun provideDatabase(@ApplicationContext context: Context) =
		AppDatabase.build(context)

	@Provides
	@Singleton
	fun provideFavoritesDao(database: AppDatabase) =
		database.favoritesDao()
}
