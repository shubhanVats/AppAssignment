package com.example.demoapp.data.remote.api

import com.example.demoapp.data.model.network.BaseResponse
import com.example.demoapp.data.model.network.ColorResponseObject
import com.example.demoapp.data.remote.NetworkingConstant.ColorSearchApiEndPoint
import retrofit2.http.GET

interface ApiService {
    @GET(ColorSearchApiEndPoint)
    suspend fun getColors(): BaseResponse<ArrayList<ColorResponseObject>>
}