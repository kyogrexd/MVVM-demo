package com.example.mvvm_demo.ViewModel

import androidx.lifecycle.ViewModel
import com.example.mvvm_demo.Repository.CaseOneRepository

class CaseOneViewModel: ViewModel() {
    private val repository = CaseOneRepository()

    fun saveText(text: String) {
        repository.saveText(text)
    }


}