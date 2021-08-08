package com.example.demoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.data.model.network.BaseResponse
import com.example.demoapp.data.model.network.ColorResponseObject
import com.example.demoapp.data.remote.DataState
import com.example.demoapp.data.repository.MainRepo
import com.example.demoapp.utills.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val mainRepo: MainRepo

) : ViewModel() {
    val getColorResponseData: LiveData<Event<DataState<BaseResponse<ArrayList<ColorResponseObject>>>>>
        get() = getColorResponse

    private val getColorResponse: MutableLiveData<Event<DataState<BaseResponse<ArrayList<ColorResponseObject>>>>> =
        MutableLiveData()

    fun setStateEvent(mainEvent: MainEvent) {

        viewModelScope.launch {

            when (mainEvent) {
                is MainEvent.colorResponseItem -> {

                    mainRepo.getColorResponse()
                        .onEach {

                                dataState ->
                            getColorResponse.value = Event(dataState)
                        }
                        .launchIn(viewModelScope)

                }
            }

        }

    }

    sealed class MainEvent {

        object colorResponseItem : MainEvent()

    }
}