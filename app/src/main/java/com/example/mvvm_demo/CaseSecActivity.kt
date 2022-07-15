package com.example.mvvm_demo

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_demo.ViewModel.CaseSecViewModel
import com.example.mvvm_demo.databinding.ActivitySecBinding

class CaseSecActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySecBinding
    private lateinit var viewModel: CaseSecViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CaseSecViewModel::class.java)

        binding.run {
            tvSave.setOnClickListener {
                viewModel.saveText(edContent.text.toString())
                edContent.text = null
            }

            viewModel.getText().observe(this@CaseSecActivity, Observer {
                this.tvContent.text = it
            })
        }
    }
}