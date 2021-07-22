package me.onebone.watchahomework.shared.data

import me.onebone.watchahomework.shared.data.response.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesService {
	@GET("/search")
	suspend fun search(
		@Query("term") term: String = "greenday",
		@Query("entity") entity: String = "song"
	): SearchResultResponse
}
