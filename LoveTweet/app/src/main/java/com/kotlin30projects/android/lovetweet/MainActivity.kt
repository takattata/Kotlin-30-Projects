package com.kotlin30projects.android.lovetweet

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.DatePicker
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.threeten.bp.LocalDate

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private var age: Int? = null
    private var salary: Int? = null
    private var gender: Gender? = null

    enum class Gender(val key: String) {
        MALE("male"),
        FEMALE("female")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            genderRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                gender = if (checkedId == R.id.maleButton) {
                    Gender.MALE
                } else {
                    Gender.FEMALE
                }
            }
            val defaultBirthday = LocalDate.now().minusYears(20)
            dateLayout.setOnClickListener {
                DatePickerDialogFragment.newInstance(defaultBirthday.year, defaultBirthday.monthValue, defaultBirthday.dayOfMonth)
                        .show(supportFragmentManager, "datePicker")
            }
            dateText.text = getBirthdayText(defaultBirthday.year, defaultBirthday.monthValue, defaultBirthday.dayOfMonth)
            salarySeek.progress = 10
            salarySeek.max = 1000
            salaryText.text = "$${salarySeek.progress}k"
            salarySeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    salary = progress
                    salaryText.text = "$${salary}k"
                }
            })
            tweetButton.setOnClickListener {
                if (nameText.text.isNullOrEmpty() || workText.text.isNullOrEmpty() || salary == null || age == null || gender == null) {
                    AlertDialog.Builder(this)
                            .setTitle("Info miss or invalid")
                            .setMessage("Please fill out correct personal info")
                            .setPositiveButton("OK", null)
                            .show()
                } else {
                    AlertDialog.Builder(this)
                            .setTitle("Love Tweet")
                            .setMessage("Hi, I am ${nameText.text}. As a ${age}-year-old ${workText.text} earning ${salaryText.text}/year, I am interested in ${gender?.key}. Feel free to contact me!")
                            .setPositiveButton("POST", null)
                            .setNegativeButton("Cancel", null)
                            .show()
                }
            }
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        age = LocalDate.now().year - year
        dateText.text = getBirthdayText(year, month+1, dayOfMonth)
    }

    private fun getBirthdayText(year: Int, month: Int, dayOfMonth: Int): String = "$year/$month/$dayOfMonth"
}
