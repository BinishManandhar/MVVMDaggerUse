package com.binish.mvvmdaggeruse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binish.mvvmdaggeruse.adapters.RecyclerViewAdapter
import com.binish.mvvmdaggeruse.models.AlexaModel
import com.binish.mvvmdaggeruse.viewmodels.DataViewModel

class MainActivity : AppCompatActivity() {
    var dataViewModel: DataViewModel? = null
    var recyclerAdapter: RecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        initRecyclerView()

        dataViewModel!!.getAlexaData()?.observe(this, Observer<MutableList<AlexaModel>> {
                recyclerAdapter?.notifyDataSetChanged()
        })

    }

    fun initRecyclerView(){
        recyclerAdapter = RecyclerViewAdapter(this,dataViewModel?.getAlexaData()?.value)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter
    }
}
