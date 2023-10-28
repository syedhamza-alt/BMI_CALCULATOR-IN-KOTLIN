package com.example.materialui.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    fun insertLogin(bmi: BMI);
}