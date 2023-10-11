package com.kguard.data.model.dto

data class BikeList(
    val rackTotCnt: Int,
    val stationName: String,
    val parkingBikeTotCnt: Int,
    val shared: String,
    val stationLatitude: String,
    val stationLongitude: String,
    val stationId: String
)