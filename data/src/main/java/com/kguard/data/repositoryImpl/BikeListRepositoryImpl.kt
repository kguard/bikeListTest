package com.kguard.data.repositoryImpl

import android.util.Log
import com.kguard.data.remote.dataSource.BikeListDataSource
import com.kguard.data.remote.mapper.BikeListMapper
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.repository.BikeListRepository
import javax.inject.Inject
import kotlin.math.log

class BikeListRepositoryImpl @Inject constructor(
    private val api : BikeListDataSource
):BikeListRepository{
    override suspend fun getBikeList(startIndex: Int, endIndex: Int): List<DomainBikeList> {
        Log.e("repository", "getBikeList: ${api.getBikeList(startIndex, endIndex)}", )
        return api.getBikeList(startIndex, endIndex).row.map {BikeListMapper.toDomainBikeList(it)}
    }
}