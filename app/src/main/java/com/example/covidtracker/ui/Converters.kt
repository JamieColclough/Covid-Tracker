package com.example.covidtracker.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion


@BindingAdapter("caseColour")
public fun setCaseColour(view: TextView, numberOfCases: Int){
    view.setTextColor(when{
        numberOfCases < 1000 -> Color.BLUE
        numberOfCases < 5000 -> Color.GREEN
        numberOfCases < 40000 -> Color.YELLOW
        else -> Color.RED
    })
}