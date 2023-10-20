package com.kguard.data.remote.dataSource

import com.kguard.data.extension.ResponseState
import com.kguard.data.model.dto.RowRes
import com.kguard.data.model.dto.BikeListTestRes
import com.kguard.data.model.dto.RentBikeStatusRes
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface BikeListDataSource {
    suspend fun getBikeList(startIndex: Int,endIndex: Int): BikeListTestRes
    suspend fun getBikeListFlow(startIndex : Int, endIndex : Int): Flow<BikeListTestRes>
    suspend fun getBikeListWithResponseState(startIndex: Int, endIndex: Int): ResponseState<RentBikeStatusRes>


}