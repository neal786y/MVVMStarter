package com.lbys.mvvmstarter.repositories

import com.lbys.mvvmstarter.models.Movie
import com.lbys.mvvmstarter.models.MyData
import com.lbys.mvvmstarter.models.SearchResponse
import com.lbys.mvvmstarter.network.MyApiService
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(private val myApiService: MyApiService) {

    suspend fun getDataFromApi(): MyData? {
        return myApiService.getData().body()
    }

    suspend fun getMovies(query: String): Response<SearchResponse> {
        return myApiService.searchMovies(query)
    }

    suspend fun getMovieDetails(imdbID: String): Response<Movie> {
        return myApiService.getMovieDetails(imdbID)
    }
}
