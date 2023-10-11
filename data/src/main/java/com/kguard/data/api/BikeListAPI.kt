package com.kguard.data.api

import com.kguard.data.BuildConfig
import com.kguard.data.model.dto.BikeListTest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BikeListAPI {
    @GET("${BuildConfig.API_KEY}/json/bikeList/{startIndex}/{endIndex}/")
    suspend fun getBikeListWithResponse(
        @Path("startIndex")
        startIndex : Int,
        @Path("endIndex")
        endIndex : Int
    ): Response<BikeListTest>

    @GET("${BuildConfig.API_KEY}/json/bikeList/{startIndex}/{endIndex}/")
    suspend fun getBikeList(
        @Path("startIndex")
        startIndex : Int,
        @Path("endIndex")
        endIndex : Int
    ): BikeListTest
}