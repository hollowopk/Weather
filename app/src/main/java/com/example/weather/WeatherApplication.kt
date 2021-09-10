package com.example.weather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class WeatherApplication : Application() {

    companion object {
        const val TOKEN = "Oegq74WHiu9yum3g"
        @SuppressLint("StaticFieldLeak")
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}