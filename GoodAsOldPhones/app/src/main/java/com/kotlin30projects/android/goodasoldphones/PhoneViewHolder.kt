package com.kotlin30projects.android.goodasoldphones

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Yuri Takashima on 2018/04/26.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

class PhoneViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val iconImage: ImageView = view.findViewById(R.id.phoneIcon)
    val titleText: TextView = view.findViewById(R.id.titleText)
}
