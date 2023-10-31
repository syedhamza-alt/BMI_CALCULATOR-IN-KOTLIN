package com.example.materialui.room

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["name"], unique = true)])
data class BMI(
    @PrimaryKey(autoGenerate = true)

    val id: Long = 0,
    @NonNull

    val name: String,
    val height: Double,
    val weight: Double,

    )
