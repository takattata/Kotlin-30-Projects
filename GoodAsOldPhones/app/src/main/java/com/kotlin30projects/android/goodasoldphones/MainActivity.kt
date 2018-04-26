package com.kotlin30projects.android.goodasoldphones

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    enum class BottomNavigation(val title: String) {
        PRODUCTS("Products"),
        US("Us")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        if (savedInstanceState == null) {
            setupProductsFragment()
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.title) {
                BottomNavigation.PRODUCTS.title -> {
                    setupProductsFragment()
                    true
                }
                BottomNavigation.US.title -> {
                    setupUsFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupProductsFragment() {
        ProductsFragment().apply {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, this)
                    .commit()
        }
    }

    private fun setupUsFragment() {
        UsFragment().apply {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, this)
                    .commit()
        }
    }
}
