package com.example.dihilt.mvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.dihilt.R
import com.example.dihilt.databinding.ActivityDataBinding
import com.example.dihilt.mvvm.model.response.DataItem
import com.example.dihilt.mvvm.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getData().observe(this, Observer { result ->
            result.fold(
                onSuccess = { data ->
                    displayData(data)
                },
                onFailure = { exception ->
                    Toast.makeText(this, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
                }
            )
        })
    }

    private fun displayData(data: List<DataItem>) {
        // Update your UI here with the received data
        binding.tvTemp.text = data.joinToString("\n") { it.title }
    }
}