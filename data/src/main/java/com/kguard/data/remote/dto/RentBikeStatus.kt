package com.kguard.data.remote.dto

import com.google.gson.annotations.SerializedName


data class RentBikeStatus(
    @SerializedName("list_total_count")
    val listTotalCount: Int,
    @SerializedName("RESULT")
    val result: ResultResponse,
    @SerializedName("row")
    val row: List<BikeList>
)