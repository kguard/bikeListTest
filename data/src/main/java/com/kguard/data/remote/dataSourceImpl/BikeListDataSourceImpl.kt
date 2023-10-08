package com.kguard.data.remote.dataSourceImpl

import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.remote.dto.rentBikeStatus
import retrofit2.Retrofit
import javax.inject.Inject

class BikeListDataSourceImpl @Inject constructor(private val retrofit: Retrofit):BikeListDataSource{
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): rentBikeStatus {
        return retrofit.create(BikeListDataSource::class.java).getBikeList(startIndex,endIndex)
    }
}