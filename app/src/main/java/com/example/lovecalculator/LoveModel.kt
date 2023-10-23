package com.example.lovecalculator

import android.health.connect.datatypes.units.Percentage
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveModel(

    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var sName: String,
    var percentage: String,
    var result: String,
): Serializable
