package com.kguard.data.model.dto

import com.google.gson.annotations.SerializedName

data class BikeListTestRes(
    @SerializedName("rentBikeStatus")
    val rentBikeStatus: RentBikeStatusRes

)