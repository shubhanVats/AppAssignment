package com.example.demoapp.data.repository

import com.example.demoapp.data.remote.api.ApiService
import com.example.demoapp.data.remote.api.SafeApiRequest
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService,
    private val safeApiRequest: SafeApiRequest
)