package com.kotlin30projects.android.goodasoldphones

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_products.*
import timber.log.Timber

/**
 * Created by Yuri Takashima on 2018/04/26.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

class ProductsFragment : Fragment(), PhoneRecyclerViewAdapterListener {
    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var adapter: PhoneRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_products, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PhoneRecyclerViewAdapter()
        adapter.listener = this
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onClick(imageId: Int, text: String) {
        val intent = Intent(context, ProductActivity::class.java).apply {
            putExtra(ProductActivity.Argument.BACKGROUND_IMAGE.key, imageId)
            putExtra(ProductActivity.Argument.TITLE_TEXT.key, text)
        }
        startActivity(intent)
    }
}
