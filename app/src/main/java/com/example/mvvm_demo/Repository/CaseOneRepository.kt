package com.example.mvvm_demo.Repository

import com.example.mvvm_demo.Data.CaseOneData
import com.example.mvvm_demo.DataManager

class CaseOneRepository {
    companion object {
        private var data = ArrayList<CaseOneData>()
    }

    init {
        DataManager.instance.getCase1Data(1234) {
            data = it?.dataList ?: ArrayList()
        }
    }

    fun saveText(text: String) {
        data.add(CaseOneData(data.size, text))
        DataManager.instance.setCase1Data(1234, data)
    }

    fun getAllText() = data
}