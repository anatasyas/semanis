package com.example.simanisapp.response

import com.example.simanisapp.database.PredictionRequest
import com.example.simanisapp.database.PredictionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PredictionApi {
    @POST("/predict")
    fun getPrediction(@Body request: PredictionRequest): Call<PredictionResponse>
}
