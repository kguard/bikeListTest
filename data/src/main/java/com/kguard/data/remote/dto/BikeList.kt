package com.kguard.data.remote.dto

data class BikeList(
    val rackToCnt: String,
    val stationName: String,
    val parkingBikeToCnt: String,
    val shared: String,
    val stationLatitude: String,
    val stationLongitude: String,
    val stationId: String
)