package com.kguard.data.remote.dataSourceImpl

import com.kguard.data.api.BikeListAPI
import com.kguard.data.extension.ErrorState
import com.kguard.data.extension.errorHandler
import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.model.dto.BikeListTest
import com.kguard.domain.state.ResultState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class BikeListDataSourceImpl @Inject constructor(private val api: BikeListAPI):BikeListDataSource{
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): ResultState<BikeListTest> {
        return when(val response = api.getBikeListWithResponse(startIndex,endIndex).errorHandler()){
            is ErrorState.Success ->{
                ResultState.Success(data = response.data)
            }
            is ErrorState.Error -> {
                ResultState.Error( failure = response.failure)
            }
        }
    }

    override suspend fun getBikeListFlow(startIndex: Int, endIndex: Int): Flow<BikeListTest>{
        var start = startIndex
        var end = endIndex
        return flow{
            while(true)
            {
                start += 1
                end += 1
                emit(api.getBikeList(start, end))
                delay(10000)
            }
        }
    }

}
