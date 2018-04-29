package com.kotlin30projects.android.stopwatch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_lap_holder.view.*
import timber.log.Timber

/**
 * Created by Yuri Takashima on 2018/04/29.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

class LapViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun setup(number: Int, timeText: String) {
        itemView.lapNumberText.text = "Lap $number"
        itemView.lapTimeText.text = timeText
    }
}

class LapRecycleViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var laps = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder =
            LapViewHolder(LayoutInflater.from(context).inflate(R.layout.view_lap_holder, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (laps.size > position) {
            Timber.d("size: ${laps.size}, position: $position, number: ${laps.size - position}, index: ${laps.size - position}")
            (holder as LapViewHolder).setup(laps.size - position, laps[laps.size - 1 - position])
        }
    }

    override fun getItemCount(): Int = laps.size
}
