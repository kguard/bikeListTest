package com.kguard.data.remote.dataSource

import com.kguard.data.BuildConfig
import com.kguard.data.model.dto.BikeListTest
import com.kguard.data.model.dto.RentBikeStatus
import com.kguard.domain.state.ResultState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BikeListDataSource {
    suspend fun getBikeList(startIndex: Int,endIndex: Int): ResultState<BikeListTest>
    suspend fun getBikeListFlow(startIndex : Int, endIndex : Int): Flow<BikeListTest>
}