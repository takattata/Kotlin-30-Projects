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
    companion object {
        fun newInstance() = DatePickerDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val themeContext = if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
//            ContextThemeWrapper(context, R.style.DatePickerDialog_Holo)
//        } else {
//            ContextThemeWrapper(context, R.style.DatePickerDialog_Material)
//        }
        val now = LocalDate.now().minusYears(20)
        return DatePickerDialog(/*themeContext*/context, activity as? MainActivity, now.year, now.month.value, now.dayOfMonth)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {}
}
