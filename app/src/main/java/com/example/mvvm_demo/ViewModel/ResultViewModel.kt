package com.example.mvvm_demo.ViewModel

import androidx.lifecycle.ViewModel
import com.example.mvvm_demo.Repository.CaseOneRepository

class ResultViewModel: ViewModel() {
    private val repository = CaseOneRepository()

    fun getAllText() = repository.getAllText()
}