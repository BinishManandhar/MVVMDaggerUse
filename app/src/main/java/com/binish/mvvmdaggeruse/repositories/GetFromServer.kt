package com.binish.mvvmdaggeruse.repositories

import com.binish.mvvmdaggeruse.models.AlexaModel
import com.binish.mvvmdaggeruse.ownRetrofitAdapter.Simple
import retrofit2.http.GET

interface GetFromServer {
    @GET("/google.com")
    fun getAlexaData(): Simple<AlexaModel>
}