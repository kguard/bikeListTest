package com.kguard.data.api

import com.kguard.data.BuildConfig
import com.kguard.data.extension.ResponseState
import com.kguard.data.model.dto.BikeListTestRes
import com.kguard.data.model.dto.RentBikeStatusRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BikeListAPI {
    @GET("${BuildConfig.API_KEY}/json/bikeList/{startIndex}/{endIndex}/")
    suspend fun getBikeListWithResponseState(
        @Path("startIndex")
        startIndex : Int,
        @Path("endIndex")
        endIndex : Int
    ): ResponseState<RentBikeStatusRes>

    @GET("${BuildConfig.API_KEY}/json/bikeList/{startIndex}/{endIndex}/")
    suspend fun getBikeList(
        @Path("startIndex")
        startIndex : Int,
        @Path("endIndex")
        endIndex : Int
    ): BikeListTestRes
}