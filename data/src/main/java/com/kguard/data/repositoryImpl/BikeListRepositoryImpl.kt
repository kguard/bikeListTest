package com.kguard.data.repositoryImpl

import android.util.Log
import com.kguard.data.extension.ResponseState
import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.mapper.BikeListMapper
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.state.ResultState
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BikeListRepositoryImpl @Inject constructor(
    private val dataSource: BikeListDataSource) : BikeListRepository {
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): List<DomainBikeList> =
        dataSource.getBikeList(startIndex, endIndex).rentBikeStatus.row.map { BikeListMapper.toDomainBikeList(it) }

    override suspend fun getBikeListFlow(startIndex: Int, endIndex: Int) =
        dataSource.getBikeListFlow(startIndex, endIndex).map { bikeListTest ->
            bikeListTest.rentBikeStatus.row.map {
                BikeListMapper.toDomainBikeList(it)
            }
        }

    override suspend fun getBikeListWithResponseState(
        startIndex: Int,
        endIndex: Int
    ): ResultState<List<DomainBikeList>> {
        Log.e("repository", "repository:getBikeListWithResponseState: ${dataSource.getBikeListWithResponseState(startIndex, endIndex)} " )
        return when(val bikeList = dataSource.getBikeListWithResponseState(startIndex, endIndex)){
            is ResponseState.Success -> ResultState.Success(bikeList.data.row.map { BikeListMapper.toDomainBikeList(it) })
            is ResponseState.Fail.Error -> ResultState.Fail.Error(bikeList.code,bikeList.message)
            is ResponseState.Fail.Exception -> ResultState.Fail.Exception(bikeList.e,bikeList.message)
        }
    }
}