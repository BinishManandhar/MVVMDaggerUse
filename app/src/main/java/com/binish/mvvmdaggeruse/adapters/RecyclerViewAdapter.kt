package com.binish.mvvmdaggeruse.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binish.mvvmdaggeruse.R
import com.binish.mvvmdaggeruse.models.AlexaModel

class RecyclerViewAdapter(var context: Context?, private var alexaModel: MutableList<AlexaModel>?) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.individual_data,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alexa = alexaModel?.get(position)
        holder.result.text = alexa?.result
        holder.message.text = alexa?.message
    }

    override fun getItemCount(): Int {
        return alexaModel?.size ?: 1
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var result: TextView = itemView.findViewById(R.id.globalRank)
    var message: TextView = itemView.findViewById(R.id.countryRank)
}