package com.kguard.domain.repository
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.state.ResultState
import kotlinx.coroutines.flow.Flow

interface BikeListRepository {
    //suspend fun getBikeList(startIndex: Int, endIndex:Int) : ResultState<List<DomainBikeList>>
    suspend fun getBikeListFlow(startIndex: Int, endIndex: Int) : Flow<List<DomainBikeList>>
}