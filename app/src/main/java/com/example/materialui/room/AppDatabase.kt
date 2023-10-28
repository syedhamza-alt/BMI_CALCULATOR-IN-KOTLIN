package com.example.materialui.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.materialui.MainActivity

@Database(entities =[BMI::class], version = 3 )
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}