package com.example.gradlefix.presentation.UI

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gradlefix.R
import com.example.gradlefix.guerrero.GuerreroViewModel
import com.example.gradlefix.presentation.GuerreroAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: GuerreroViewModel
    private lateinit var adapter: GuerreroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = GuerreroAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[GuerreroViewModel::class.java]
        viewModel.guerreros.observe(this) { pagingData ->
            adapter.submitData(lifecycle, pagingData)
        }
    }
}