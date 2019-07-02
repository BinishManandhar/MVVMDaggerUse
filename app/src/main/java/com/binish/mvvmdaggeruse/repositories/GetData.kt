package com.binish.mvvmdaggeruse.repositories

import androidx.lifecycle.MutableLiveData
import com.binish.mvvmdaggeruse.models.AlexaModel

class GetData{
    private var alexaModel: ArrayList<AlexaModel> ?= ArrayList()
    companion object {
        private var instance: GetData? = null
        fun getInstance(): GetData {
            if (instance == null)
                instance = GetData()
            return instance as GetData
        }
    }

    fun getData():MutableLiveData<ArrayList<AlexaModel>>? {
        val service = RetrofitClientInstance.getRetrofitInstance()?.create(GetFromServer::class.java)
        val call = service?.getAlexaData()
        call?.process { list, throwable ->
            if (list != null) {
                alexaModel?.add(list)
            }


        }
        val data = MutableLiveData<ArrayList<AlexaModel>>()
        data.value = alexaModel
        return data
    }
}

