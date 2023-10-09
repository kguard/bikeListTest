package com.kguard.data.remote.mapper

import com.kguard.data.remote.dto.BikeList
import com.kguard.domain.model.DomainBikeList

object BikeListMapper {
    fun toDomainBikeList(bikeList: BikeList): DomainBikeList =
        DomainBikeList(
            rackToCnt = bikeList.rackTotCnt.toString(),
            stationName = bikeList.stationName,
            parkingBikeToCnt = bikeList.parkingBikeTotCnt.toString(),
            shared = bikeList.shared,
            stationLatitude = bikeList.stationLatitude,
            stationLongitude = bikeList.stationLongitude,
            stationId = bikeList.stationId
        )
}
