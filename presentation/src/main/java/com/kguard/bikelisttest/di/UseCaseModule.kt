package com.kguard.bikelisttest.di

import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.usecase.BikeListFlowUseCase
import com.kguard.domain.usecase.BikeListLiveDataUseCase
import com.kguard.domain.usecase.BikeListWithResponseStateUseCase
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

    @Provides
    @Singleton
    fun provideBikeListWithResponseStateUseCase(repository: BikeListRepository): BikeListWithResponseStateUseCase {
        return BikeListWithResponseStateUseCase(repository)
    }



}