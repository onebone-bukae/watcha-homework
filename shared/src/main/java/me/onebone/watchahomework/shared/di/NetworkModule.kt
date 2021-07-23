package me.onebone.watchahomework.shared.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import me.onebone.watchahomework.shared.BuildConfig
import me.onebone.watchahomework.shared.data.FavoritesDataSource
import me.onebone.watchahomework.shared.data.ITunesDataSource
import me.onebone.watchahomework.shared.data.ITunesService
import me.onebone.watchahomework.shared.data.NetworkITunesDataSource
import me.onebone.watchahomework.shared.data.RoomFavoritesDataSource
import me.onebone.watchahomework.shared.repository.FavoritesRepository
import me.onebone.watchahomework.shared.repository.FavoritesRepositoryImpl
import me.onebone.watchahomework.shared.repository.ITunesRepository
import me.onebone.watchahomework.shared.repository.ITunesRepositoryImpl
import okhttp3.MediaType
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
	@Provides
	@Singleton
	fun provideJson(): Json =
		Json { ignoreUnknownKeys = true }

	@OptIn(ExperimentalSerializationApi::class)
	@Provides
	@Singleton
	fun provideJsonConverter(json: Json) =
		json.asConverterFactory(MediaType.parse("application/json")!!)


	@Provides
	@Singleton
	fun provideRetrofit(
		converterFactory: Converter.Factory
	): Retrofit =
		Retrofit.Builder()
			.baseUrl(BuildConfig.ITUNES_API_BASE_URL)
			.addConverterFactory(converterFactory)
			.build()

	@Provides
	@Singleton
	fun provideITunesService(retrofit: Retrofit): ITunesService =
		retrofit.create(ITunesService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkBindsModule {
	@Binds
	@Singleton
	abstract fun bindITunesDataSource(dataSource: NetworkITunesDataSource): ITunesDataSource

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
