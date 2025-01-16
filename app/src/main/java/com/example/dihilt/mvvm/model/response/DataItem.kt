package com.example.dihilt.mvvm.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class DataItem(
    @PrimaryKey(autoGenerate = true)
    val priId: Int = 0,
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)