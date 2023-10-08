package com.kguard.data.remote.dataSource

import com.kguard.data.BuildConfig
import com.kguard.data.remote.dto.rentBikeStatus
import retrofit2.http.GET
import retrofit2.http.Path

interface BikeListDataSource {
    @GET("${BuildConfig.API_KEY}/json/bikeList/{startIndex}/{endIndex}/")
    suspend fun getBikeList(
        @Path("startIndex")
        startIndex : Int,
        @Path("endIndex")
        endIndex : Int
    ):rentBikeStatus
}