package com.route.islamyapplication.radio.api.models

import com.google.gson.annotations.SerializedName

data class Radio(
    val id: Int,
    val name: String,
    @SerializedName("recent_date")
    val recentDate: String,
    val url: String
)