package com.example.simanisapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.simanisapp.R


class InputUserDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_user_data)

        val genderSpinner: Spinner = findViewById(R.id.spinner_jenis_kelamin)
        val activitySpinner: Spinner = findViewById(R.id.spinner_jenis_aktivitas)
        val diabetesSpinner: Spinner = findViewById(R.id.spinner_riwayat_diabetes)

        val genderAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listOf("Pilih Tingkat Aktivitas", "Laki-laki", "Perempuan")
        )
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = genderAdapter

        val activityAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listOf("Pilih Tingkat Aktivitas", "Tinggi", "Sedang", "Rendah")
        )
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activitySpinner.adapter = activityAdapter

        val diabetesAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listOf("Pilih Tingkat Aktivitas", "Iya", "Tidak")
        )
        diabetesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        diabetesSpinner.adapter = diabetesAdapter

        val btnStart: Button = findViewById(R.id.button2)
        btnStart.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        }
    }
