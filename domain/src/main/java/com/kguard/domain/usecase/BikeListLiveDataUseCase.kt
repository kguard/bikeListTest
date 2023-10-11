package com.kguard.domain.usecase

import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.state.ResultState

class BikeListLiveDataUseCase(private val repository: BikeListRepository) {
//    suspend operator fun invoke(startIndex: Int, endIndex: Int): ResultState<List<DomainBikeList>> =
//        repository.getBikeList(startIndex, endIndex)
}