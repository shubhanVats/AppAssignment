package com.example.demoapp.data.remote.api

import com.example.demoapp.data.model.network.BaseResponse
import com.example.demoapp.data.model.network.ColorResponseObject
import retrofit2.http.GET

interface ApiService {
    @GET("colors?keywords=SEARCH+TERMS&format=json&numResults=20")
    suspend fun getColors(): BaseResponse<ArrayList<ColorResponseObject>>
}