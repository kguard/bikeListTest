package com.kguard.domain.usecase

import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository

class BikeListUseCase(private val repository: BikeListRepository) {
    suspend fun getBikeList(startIndex:Int, endIndex:Int): List<DomainBikeList>
    {
        return repository.getBikeList(startIndex,endIndex)
    }

}