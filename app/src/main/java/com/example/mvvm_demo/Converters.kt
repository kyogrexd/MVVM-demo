package com.example.mvvm_demo

import androidx.room.TypeConverter
import com.example.mvvm_demo.Data.CaseOneData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class Converters {
    @TypeConverter
    fun fromString(value: String): ArrayList<Int> {
        val listType = object : TypeToken<ArrayList<Int>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Int>): String {
        return Gson().toJson(list)
    }
}

open class ArrayListStringConverters {
    @TypeConverter
    fun fromString(value: String): ArrayList<String> {
        val listType = object : TypeToken<ArrayList<String>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        return Gson().toJson(list)
    }
}

class Case1Converters: ArrayListStringConverters() {
    @TypeConverter
    fun fromClass(value: String): ArrayList<CaseOneData> {
        val listType = object : TypeToken<ArrayList<CaseOneData>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromString(value: ArrayList<CaseOneData>): String {
        return Gson().toJson(value)
    }
}