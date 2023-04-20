package com.lbys.mvvmstarter.network

import com.lbys.mvvmstarter.models.Movie
import com.lbys.mvvmstarter.models.MyData
import com.lbys.mvvmstarter.models.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApiService {
    @GET("data")
    suspend fun getData(): Response<MyData>

    @GET("API/Search/k_w35dr7b5/{expression}")
    suspend fun searchMovies(
        @Path("expression") query: String
    ): Response<SearchResponse>

    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbID: String
    ): Response<Movie>
}
