package com.kotlin30projects.android.lovetweet

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.view.ContextThemeWrapper
import android.widget.DatePicker
import org.threeten.bp.LocalDate

/**
 * Created by Yuri Takashima on 2018/04/27.
 *
 * Copyright © 2018 Cluex inc. All rights reserved.
 */

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    var year = 1999
    var month = 1
    var day = 1

    companion object {
        fun newInstance(year: Int, month: Int, dayOfMonth: Int): DatePickerDialogFragment {
            return DatePickerDialogFragment().apply {
                val arguments = Bundle().apply {
                    putInt(Argument.YEAR.key, year)
                    putInt(Argument.MONTH.key, month)
                    putInt(Argument.DAY.key, dayOfMonth)
                }
                this.arguments = arguments
            }
        }
    }

    private enum class Argument(val key: String) {
        YEAR("year"),
        MONTH("month"),
        DAY("day")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val themeContext = if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
//            ContextThemeWrapper(context, R.style.DatePickerDialog_Holo)
//        } else {
//            ContextThemeWrapper(context, R.style.DatePickerDialog_Material)
//        }
        arguments?.let {
            year = it.getInt(Argument.YEAR.key)
            month = it.getInt(Argument.MONTH.key)
            day = it.getInt(Argument.DAY.key)
        }
        return DatePickerDialog(/*themeContext*/context, activity as? MainActivity, year, month-1, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {}
}
