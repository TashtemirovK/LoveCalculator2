package com.example.lovecalculator

import android.health.connect.datatypes.units.Percentage
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    val percentage: String,
    val result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
) : Serializable
