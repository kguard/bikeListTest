package com.kguard.bikelisttest.di

import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.remote.dataSourceImpl.BikeListDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideBikeListDataSource(
        retrofit: Retrofit
    ): BikeListDataSource {
        return BikeListDataSourceImpl(retrofit)
    }
}