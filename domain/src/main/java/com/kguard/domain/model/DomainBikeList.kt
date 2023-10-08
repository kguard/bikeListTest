package com.kguard.domain.model

data class DomainBikeList(
    val rackToCnt: String,
    val stationName: String,
    val parkingBikeToCnt: String,
    val shared: String,
    val stationLatitude: String,
    val stationLongitude: String,
    val stationId: String
)
