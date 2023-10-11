package com.kguard.data.repositoryImpl

import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.mapper.BikeListMapper
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.state.ResultState
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BikeListRepositoryImpl @Inject constructor(
    private val dataSource: BikeListDataSource) : BikeListRepository {
//    override suspend fun getBikeList(startIndex: Int, endIndex: Int): ResultState<List<DomainBikeList>> {
//        return when(val resultState = dataSource.getBikeList(startIndex,endIndex))
//        {
//            is ResultState.Success -> {
//                val repository = resultState.data.rentBikeStatus.row.map { BikeListMapper.toDomainBikeList(it) }
//                ResultState.Success(data = repository)
//            }
//            is ResultState.Error -> {
//                ResultState.Error(failure = resultState.failure)
//            }
//
//        }
////        Log.e(
////            "repository",
////            "repository: ${dataSource.getBikeList(startIndex, endIndex).rentBikeStatus.row}",
////        )
////        return dataSource.getBikeList(
////            startIndex,
////            endIndex
////        ).rentBikeStatus.row.map { BikeListMapper.toDomainBikeList(it) }
//
//    }

    override suspend fun getBikeListFlow(startIndex: Int, endIndex: Int) =
        dataSource.getBikeListFlow(startIndex, endIndex).map { bikeListTest ->
            bikeListTest.rentBikeStatus.row.map {
                BikeListMapper.toDomainBikeList(it)
            }
        }
}