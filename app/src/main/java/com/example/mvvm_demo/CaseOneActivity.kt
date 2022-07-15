package com.example.mvvm_demo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_demo.ViewModel.CaseOneViewModel
import com.example.mvvm_demo.databinding.ActivityCaseoneBinding

class CaseOneActivity: AppCompatActivity() {
    private lateinit var viewModel: CaseOneViewModel
    private lateinit var binding: ActivityCaseoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaseoneBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CaseOneViewModel::class.java)

        binding.run {
            tvSave.setOnClickListener {
                viewModel.saveText(edContent.text.toString())
                edContent.text = null
            }

            tvResult.setOnClickListener {
                startActivity(Intent(this@CaseOneActivity, ResultActivity::class.java))
            }
        }
    }
}