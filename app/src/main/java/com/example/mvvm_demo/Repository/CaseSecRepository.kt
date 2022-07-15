package com.example.mvvm_demo.Repository

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_demo.Data.CaseOneData

class CaseSecRepository {
    companion object {
        private var data = MutableLiveData<String>()
    }

    init {
        data.value = "init"
    }

    fun saveText(text: String) {
        data.value = text
    }

    fun getText() = data
}