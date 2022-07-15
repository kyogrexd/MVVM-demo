package com.example.mvvm_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.mvvm_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        DataManager.instance.initDataStore(this)

        binding.tvCase1.setOnClickListener {
            startActivity(Intent(this@MainActivity, CaseOneActivity::class.java))
        }

        binding.tvCase2.setOnClickListener {
            startActivity(Intent(this@MainActivity, CaseSecActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        DataManager.instance.closeDatabase()
    }
}