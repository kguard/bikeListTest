package com.kguard.domain.usecase

import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BikeListFlowUseCase(private val repository: BikeListRepository) {
    suspend operator fun invoke(startIndex: Int, endIndex:Int): Flow<List<DomainBikeList>> = repository.getBikeListFlow(startIndex, endIndex)

}