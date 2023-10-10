package com.kguard.domain.repository

import com.kguard.domain.model.DomainBikeList
import kotlinx.coroutines.flow.Flow

interface BikeListRepository {
    suspend fun getBikeList(startIndex: Int, endIndex:Int) : List<DomainBikeList>
    suspend fun getBikeListFlow(startIndex: Int, endIndex: Int) : Flow<List<DomainBikeList>>
}