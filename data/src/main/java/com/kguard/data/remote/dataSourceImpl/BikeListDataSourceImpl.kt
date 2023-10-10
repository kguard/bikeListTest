package com.kguard.data.remote.dataSourceImpl

import android.util.Log
import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.remote.dto.BikeListTest
import com.kguard.data.remote.dto.RentBikeStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class BikeListDataSourceImpl @Inject constructor(private val retrofit: Retrofit):BikeListDataSource{
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): BikeListTest {
        Log.e("datasource", "datasource: ${retrofit.create(BikeListDataSource::class.java).getBikeList(startIndex,endIndex)}", )
        return retrofit.create(BikeListDataSource::class.java).getBikeList(startIndex,endIndex)
    }

    override suspend fun getBikeListFlow(startIndex: Int, endIndex: Int): Flow<BikeListTest> {
        var start = startIndex
        var end =endIndex
        return flow{
            while(true)
            {
                start += 1
                end += 1
                emit(retrofit.create(BikeListDataSource::class.java).getBikeList(start, end))
                delay(10000)
            }

        }
    }
}