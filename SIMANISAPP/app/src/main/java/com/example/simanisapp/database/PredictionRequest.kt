package com.example.simanisapp.database

data class PredictionRequest(
    val jenis_kelamin: String,
    val riwayat_diabetes: String,
    val tingkat_aktivitas: String,
    val umur: String,
    val berat_badan: Double
)
