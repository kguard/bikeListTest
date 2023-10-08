package com.kguard.bikelisttest.di

import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.repositoryImpl.BikeListRepositoryImpl
import com.kguard.domain.repository.BikeListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBikeListRepository(
        api: BikeListDataSource
    ): BikeListRepository {
        return BikeListRepositoryImpl(api)
    }
}