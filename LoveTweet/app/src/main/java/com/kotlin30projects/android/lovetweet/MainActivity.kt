package com.kotlin30projects.android.lovetweet

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.DatePicker
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import org.threeten.bp.LocalDate

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private var year = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val defaultBirthday = LocalDate.now().minusYears(20)
            year = defaultBirthday.year
            dateText.text = getBirthdayText(defaultBirthday.year, defaultBirthday.monthValue, defaultBirthday.dayOfMonth)
            salarySeek.progress = 10
            salarySeek.max = 1000
            salaryText.text = "$${salarySeek.progress}k"
            salarySeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    salaryText.text = "$${progress}k"
                }
            })
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        this.year = year
        dateText.text = getBirthdayText(year, month, dayOfMonth)
    }

    fun showDatePickerDialog(view: View) {
        DatePickerDialogFragment.newInstance().show(supportFragmentManager, "datePicker")
    }

    private fun getBirthdayText(year: Int, month: Int, dayOfMonth: Int): String = "$year/${month+1}/$dayOfMonth"
}
