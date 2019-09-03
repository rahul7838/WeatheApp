package com.example.weatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class RecyclerViewAdapter(private val listOfDayTemp: ArrayList<Pair<String, String>>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = listOfDayTemp.size-1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day.text = listOfDayTemp[position+1].second
        holder.temp.text = listOfDayTemp[position+1].first
    }


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var day: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.day_id)
        var temp: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.day_temp_id)
    }
}