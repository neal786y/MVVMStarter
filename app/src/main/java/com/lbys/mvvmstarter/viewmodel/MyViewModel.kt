package com.lbys.mvvmstarter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lbys.mvvmstarter.models.Movie
import com.lbys.mvvmstarter.models.MyData
import com.lbys.mvvmstarter.network.MyApiClient
import com.lbys.mvvmstarter.repositories.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val myRepository: MyRepository) : ViewModel() {
    private val _myData = MutableLiveData<MyData>()
    val myData: LiveData<MyData> = _myData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun fetchData() {
        viewModelScope.launch {
            _loading.value = true
            val response = myRepository.getDataFromApi()
            _myData.value = response!!
            _loading.value = false
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = myRepository.getMovies(query)
                if (response.isSuccessful) {
                    val searchResponse = response.body()
                    if (searchResponse?.results?.isNotEmpty() == true) {
                        _movies.value = searchResponse.results
                    } else {
                        Log.d("MyFragment", searchResponse?.errorMessage ?: "Error")
                        _movies.value = emptyList()
                    }
                } else {
                    Log.d("MyFragment", response.errorBody().toString())
                    _movies.value = emptyList()
                }
                _loading.value = false
            } catch (e: Exception) {
                _loading.value = false
                _movies.value = emptyList()
                e.printStackTrace()
            }
        }
    }
}
