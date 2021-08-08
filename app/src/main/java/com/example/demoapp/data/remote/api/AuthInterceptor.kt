package com.example.demoapp.data.remote.api

import com.example.demoapp.BuildConfig
import com.example.demoapp.data.SessionManager
import com.example.demoapp.data.remote.NetworkingConstant.Authorization
import com.example.demoapp.data.remote.NetworkingConstant.x_Api_Key
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sessionManager: SessionManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val newBuilder = request.newBuilder()
            .addHeader(x_Api_Key, BuildConfig.API_KEY)

        runBlocking {
            newBuilder.addHeader(Authorization, sessionManager.authToken.first())
            newBuilder.build()
        }

        request = newBuilder.build()
        return chain.proceed(request)
    }

}