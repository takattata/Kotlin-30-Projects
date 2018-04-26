package com.kotlin30projects.android.goodasoldphones

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_product.*

/**
 * Created by Yuri Takashima on 2018/04/26.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

class ProductActivity : AppCompatActivity() {
    enum class Argument(val key: String) {
        BACKGROUND_IMAGE("background_image"),
        TITLE_TEXT("title_text")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product)
        if (savedInstanceState == null) {
            intent.let {
                backgroundImage.setImageResource(intent.getIntExtra(Argument.BACKGROUND_IMAGE.key, R.drawable.image_phone_fullscreen1))
                titleText.text = intent.getStringExtra(Argument.TITLE_TEXT.key)
            }
        }
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    ///TODO: Add backbutton on Toolbar.
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        finish()
//        return super.onOptionsItemSelected(item)
//    }
}
