package com.kguard.bikelisttest.di

import com.kguard.data.api.BikeListAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModule {
    @Singleton
    @Provides
    fun provideBikeListAPI(retrofit: Retrofit): BikeListAPI = retrofit.create(BikeListAPI::class.java)
}