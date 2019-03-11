package com.clean.data.remote

import com.google.gson.annotations.SerializedName

class Error(
    @SerializedName("itemname") val name: List<String>? = null
)