package com.kguard.bikelisttest.di

import com.kguard.domain.repository.BikeListRepository
import com.kguard.domain.usecase.BikeListUseCase
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
    fun provideBikeListUseCase(repository: BikeListRepository): BikeListUseCase{
        return BikeListUseCase(repository)
    }
}