package com.example.simanisapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM USERS WHERE email = :email AND password = :password LIMIT 1")
    fun loginUser(email: String, password: String): User?

    @Insert
    fun insertUser(user: User)
}
