package com.kguard.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResultResponse (
    @SerializedName("CODE")
    val code : String,
    @SerializedName("MESSAGE")
    val message : String
)