package com.example.demoapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.data.remote.DataState
import com.example.demoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setObservables()
    }

    private fun setObservables() {

        mainViewModel.getColorResponseData.observe(this, { event ->

            event.getContentIfNotHandled()?.let { dataState ->

                when (dataState) {
                    is DataState.Success -> {
                        val data = dataState.data

                        if (data.success) {
                            val colorsData = data.data

                            colorsData?.let { }
                        }
                    }
                }
            }

        })

    }
}