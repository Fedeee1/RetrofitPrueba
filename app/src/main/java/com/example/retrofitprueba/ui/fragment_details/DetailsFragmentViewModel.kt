package com.example.retrofitprueba.ui.fragment_details

import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class DetailsFragmentViewModel : ViewModel() {

    fun convertDecimetersTofeet(decimeters: Double) :  String{
        val feet = decimeters * 0.328084
        return showTwoDecimals(feet)
    }

    fun convertDecimetersToMeters(decimeters: Double) : String{
        val meters = decimeters * 0.1
        return showTwoDecimals(meters)
    }

    fun convertHectogramsToPounds(hectograms: Double):  String{
        val pound = hectograms * 0.220462
        return showTwoDecimals(pound)
    }

    fun convertHectogramsToOunces(hectograms: Double) : String{
        val ounces = hectograms * 3.5274
        return showTwoDecimals(ounces)
    }

    fun convertHectogramsToKg(hectograms: Double) : String{
        val kg = hectograms * 0.1
        return showTwoDecimals(kg)
    }

    private fun showTwoDecimals(number: Double):  String {
        val formatDecimals = DecimalFormat("#0.00")
        return formatDecimals.format(number)
    }

}