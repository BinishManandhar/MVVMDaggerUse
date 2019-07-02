package com.binish.mvvmdaggeruse.models

import com.google.gson.annotations.SerializedName

class AlexaModel {
    @SerializedName("result")
    var result: String? = null
    @SerializedName("message")
    var message: String? = null
}