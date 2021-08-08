package com.example.demoapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.adapter.ColorListAdapter
import com.example.demoapp.data.model.network.ColorResponseObject
import com.example.demoapp.data.remote.DataState
import com.example.demoapp.databinding.ActivityMainBinding
import com.example.demoapp.utills.toast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setObservables()

        mainViewModel.setStateEvent(MainViewModel.MainEvent.ColorResponseItem)
    }

    private fun setObservables() {

        mainViewModel.getColorResponseData.observe(this, { event ->

            event.getContentIfNotHandled()?.let { dataState ->

                when (dataState) {
                    is DataState.Success -> {
                        dataState.data.data?.let { bindResult(it) }
                    }
                    is DataState.GenericError -> dataState.errorResponse?.message?.let { toast(it) }
                    DataState.Loading -> Timber.e(DataState.Loading.toString())
                    is DataState.NetworkError -> toast(dataState.errorMessage)
                }
            }

        })
    }

    private fun bindResult(data: ArrayList<ColorResponseObject>) {
        activityMainBinding.apply {
            activityMainBinding.colorAdapter = ColorListAdapter()
            colorAdapter?.addItems(data)
        }
    }
}