package com.example.mvvm_demo.ViewModel

import androidx.lifecycle.ViewModel
import com.example.mvvm_demo.Repository.CaseSecRepository

class CaseSecViewModel: ViewModel() {
    private val repository = CaseSecRepository()

    fun saveText(text: String) {
        repository.saveText(text)
    }

    fun getText() = repository.getText()
}