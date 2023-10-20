package com.kguard.data.remote.dataSourceImpl

import android.util.Log
import com.kguard.data.api.BikeListAPI
import com.kguard.data.extension.ResponseState
import com.kguard.data.model.dto.RowRes
import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.model.dto.BikeListTestRes
import com.kguard.data.model.dto.RentBikeStatusRes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class BikeListDataSourceImpl @Inject constructor(private val api: BikeListAPI) :
    BikeListDataSource {
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): BikeListTestRes {
        return api.getBikeList(startIndex, endIndex)
    }

    override suspend fun getBikeListFlow(startIndex: Int, endIndex: Int): Flow<BikeListTestRes> {
        var start = startIndex
        var end = endIndex
        return flow {
            while (true) {
                start += 1
                end += 1
                emit(api.getBikeList(start, end))
                delay(10000)
            }
        }
    }

    override suspend fun getBikeListWithResponseState(
        startIndex: Int,
        endIndex: Int
    ): ResponseState<RentBikeStatusRes> {
        Log.e("dataSource", "dataSource: getBikeListWithResponse: ${api.getBikeListWithResponseState(startIndex, endIndex)}", )
        return api.getBikeListWithResponseState(startIndex, endIndex)
    }

}
