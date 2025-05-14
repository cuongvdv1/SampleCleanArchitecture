package com.example.samplecleanarchitecture.ui.department

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.samplecleanarchitecture.databinding.ActivityMainBinding

class DepartmentActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}