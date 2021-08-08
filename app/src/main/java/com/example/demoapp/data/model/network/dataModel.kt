package com.example.demoapp.data.model.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("password")
    @Expose
    val password: String,
    @SerializedName("deviceToken")
    @Expose
    val deviceToken: String
)

data class SignUpResponse(

    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("password")
    @Expose
    val password: String,
    @SerializedName("mobile")
    @Expose
    val mobileNumber: String,
    @SerializedName("deviceToken")
    @Expose
    val deviceToken: String
)