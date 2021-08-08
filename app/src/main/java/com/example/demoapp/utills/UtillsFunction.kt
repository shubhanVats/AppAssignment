package com.example.demoapp.utills

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


fun AppCompatActivity.toast(message: String) = runOnUiThread { baseContext.toast(message) }

fun Context?.toast(message: String) {
    Timber.d("Toast $message")
    this?.let { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}