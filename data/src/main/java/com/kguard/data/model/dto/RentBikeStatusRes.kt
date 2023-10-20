package com.kguard.data.model.dto

import com.google.gson.annotations.SerializedName


data class RentBikeStatusRes(
    @SerializedName("list_total_count")
    val listTotalCount: Int,
    @SerializedName("RESULT")
    val result: ResultRes,
    @SerializedName("row")
    val row: List<RowRes>
)