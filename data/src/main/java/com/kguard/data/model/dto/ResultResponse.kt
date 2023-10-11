package com.kguard.data.model.dto

import com.google.gson.annotations.SerializedName

data class ResultResponse (
    @SerializedName("CODE")
    val code : String,
    @SerializedName("MESSAGE")
    val message : String
)