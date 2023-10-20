package com.kguard.domain.usecase

import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.state.ResultState

class BikeListWithResponseStateUseCase(private val repository: BikeListRepository) {
    suspend operator fun invoke(startIndex: Int, endIndex: Int): ResultState<List<DomainBikeList>> =
        repository.getBikeListWithResponseState(startIndex, endIndex)
}