package com.example.demoapp.data.repository

import com.example.demoapp.data.remote.DataState
import com.example.demoapp.data.remote.api.ApiService
import com.example.demoapp.data.remote.api.SafeApiRequest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepo @Inject constructor(

    private val api: ApiService,
    private val safeApiRequest: SafeApiRequest

) {
    suspend fun getColorResponse() =
        flow {
            emit(DataState.Loading)
            emit(safeApiRequest.apiRequest { api.getColors() })
        }
}