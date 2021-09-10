package com.example.weather.logic

import androidx.lifecycle.liveData
import com.example.weather.logic.model.Place
import com.example.weather.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = WeatherNetwork.searchPlaces(query)
            if("ok" == placeResponse.status) {
                val places = placeResponse.places
                Result.success(places)
            }
            else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        emit(result)
    }

}