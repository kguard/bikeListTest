package com.kguard.data.remote.dataSourceImpl

import android.util.Log
import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.remote.dto.BikeListTest
import com.kguard.data.remote.dto.RentBikeStatus
import retrofit2.Retrofit
import javax.inject.Inject

class BikeListDataSourceImpl @Inject constructor(private val retrofit: Retrofit):BikeListDataSource{
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): BikeListTest {
        Log.e("datasource", "datasource: ${retrofit.create(BikeListDataSource::class.java).getBikeList(startIndex,endIndex)}", )
        return retrofit.create(BikeListDataSource::class.java).getBikeList(startIndex,endIndex)
    }
}