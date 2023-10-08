package com.kguard.domain.repository

import com.kguard.domain.model.DomainBikeList

interface BikeListRepository {
    suspend fun getBikeList(startIndex: Int, endIndex:Int) : List<DomainBikeList>
}