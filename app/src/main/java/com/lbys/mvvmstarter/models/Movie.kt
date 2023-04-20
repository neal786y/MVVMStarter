package com.lbys.mvvmstarter.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("resultType")
    val resultType: String,

    @field:SerializedName("image")
    val image: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String
)

data class SearchResponse(
    @field:SerializedName("searchType")
    val searchType: String,

    @field:SerializedName("expression")
    val expression: String,

    @field:SerializedName("results")
    val results: List<Movie>,

    @field:SerializedName("errorMessage")
    val errorMessage: String
)


