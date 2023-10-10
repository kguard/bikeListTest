package com.kguard.domain.usecase

import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository

class BikeListLiveDataUseCase(private val repository: BikeListRepository) {
    suspend operator fun invoke(startIndex: Int, endIndex: Int): List<DomainBikeList> =
        repository.getBikeList(startIndex, endIndex)
}