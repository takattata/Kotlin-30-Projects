package com.kotlin30projects.android.goodasoldphones

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.viewholder_phonetype.view.*

/**
 * Created by Yuri Takashima on 2018/04/26.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

interface PhoneRecyclerViewAdapterListener {
    fun onClick(imageId: Int, text: String)
}

class PhoneRecyclerViewAdapter : RecyclerView.Adapter<PhoneViewHolder>() {
    var listener: PhoneRecyclerViewAdapterListener? = null
    private val imageList = listOf<Int>(R.drawable.image_phone_fullscreen1, R.drawable.image_phone_fullscreen2, R.drawable.image_phone_fullscreen3, R.drawable.image_phone_fullscreen4)
    private val iconList = listOf<Int>(R.drawable.image_cell1, R.drawable.image_cell2, R.drawable.image_cell3, R.drawable.image_cell4)
    private val titleList = listOf<String>("1907 Wall Set", "1921 Dial Phone", "1937 Desk Set", "1984 Moto Portable")

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhoneViewHolder =
            PhoneViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.viewholder_phonetype, parent, false))

    override fun onBindViewHolder(holder: PhoneViewHolder?, position: Int) {
        holder?.let {
            it.iconImage.setImageResource(iconList[position])
            it.titleText.text = titleList[position]
            holder.itemView.setOnClickListener {
                listener?.onClick(imageList[position], titleList[position])
            }
        }
    }

    override fun getItemCount(): Int = titleList.size
}
