package com.example.retrofitprueba.ui.fragment_details

import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class DetailsFragmentViewModel : ViewModel() {

    fun convertDecimetersTofeet(decimeters: Double) : Double{
        val feet = decimeters * 0.328084
        return showTwoDecimals(feet)
    }

    fun convertDecimetersToMeters(decimeters: Double) : Double{
        val meters = decimeters * 0.1
        return showTwoDecimals(meters)
    }

    fun convertHectogramsToPounds(hectograms: Double): Double{
        val pound = hectograms * 0.220462
        return showTwoDecimals(pound)
    }

    fun convertHectogramsToOunces(hectograms: Double) : Double{
        val ounces = hectograms * 3.5274
        return showTwoDecimals(ounces)
    }

    fun convertHectogramsToKg(hectograms: Double) : Double{
        val kg = hectograms * 0.1
        return showTwoDecimals(kg)
    }

    private fun showTwoDecimals(number: Double): Double {
        val formatDecimals = DecimalFormat("#.00")
        return formatDecimals.format(number).toDouble()
    }

}