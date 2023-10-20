package com.kguard.data.model.dto

data class RowRes(
    val rackTotCnt: Int,
    val stationName: String,
    val parkingBikeTotCnt: Int,
    val shared: String,
    val stationLatitude: String,
    val stationLongitude: String,
    val stationId: String
)