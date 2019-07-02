package com.binish.mvvmdaggeruse.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binish.mvvmdaggeruse.models.AlexaModel
import com.binish.mvvmdaggeruse.repositories.GetData

class DataViewModel : ViewModel() {
    private var alexaModel: MutableLiveData<ArrayList<AlexaModel>>? = null
    init {
        val getDatam = GetData.getInstance()
        alexaModel = getDatam.getData()
    }

    fun getAlexaData(): LiveData<ArrayList<AlexaModel>>?{
        return alexaModel
    }
}