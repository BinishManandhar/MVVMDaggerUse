package com.binish.mvvmdaggeruse.repositories

import com.binish.mvvmdaggeruse.ownRetrofitAdapter.SimpleCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance{
    companion object {
        private var retrofit: Retrofit ?= null
        private val BASE_URL = "http://172.16.16.48:8000"
        fun getRetrofitInstance(): Retrofit?{
            if(retrofit == null){
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(SimpleCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}