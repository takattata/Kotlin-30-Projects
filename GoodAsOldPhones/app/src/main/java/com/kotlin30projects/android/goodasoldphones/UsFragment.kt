package com.kotlin30projects.android.goodasoldphones

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Yuri Takashima on 2018/04/26.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

class UsFragment : Fragment() {
    companion object {
        fun newInstance() = UsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_us, container, false)
}
