package com.example.mvvm_demo

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_demo.Adapter.ResultAdapter
import com.example.mvvm_demo.ViewModel.ResultViewModel
import com.example.mvvm_demo.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: ResultViewModel
    private lateinit var adapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ResultViewModel::class.java)

        adapter = ResultAdapter(this, viewModel)
        binding.listResult.layoutManager = LinearLayoutManager(this)
        binding.listResult.adapter = adapter
    }
}