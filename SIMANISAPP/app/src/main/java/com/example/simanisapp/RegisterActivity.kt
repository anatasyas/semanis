package com.example.simanisapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simanisapp.database.AppDatabase
import com.example.simanisapp.database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailEditText = findViewById<EditText>(R.id.input_email)
        val passwordEditText = findViewById<EditText>(R.id.input_pwd)
        val confirmPasswordEditText = findViewById<EditText>(R.id.input_confirm_pwd)
        val registerButton = findViewById<Button>(R.id.button_register)
        val logintext = findViewById<TextView>(R.id.text_login)

        val userDao = AppDatabase.getDatabase(this).userDao()

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()


            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        userDao.insertUser(User(email = email, password = password))
                    }

                    launch(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity, "User registered successfully!", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
        logintext.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
