package com.kguard.bikelisttest.di

import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.usecase.BikeListFlowUseCase
import com.kguard.domain.usecase.BikeListLiveDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideBikeListLiveDataUseCase(repository: BikeListRepository): BikeListLiveDataUseCase{
        return BikeListLiveDataUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideBikeListFlowUseCase(repository: BikeListRepository): BikeListFlowUseCase {
        return BikeListFlowUseCase(repository)
    }
}