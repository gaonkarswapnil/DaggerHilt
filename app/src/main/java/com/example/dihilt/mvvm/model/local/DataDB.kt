package com.example.dihilt.mvvm.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dihilt.mvvm.model.response.DataItem

@Database(entities = [DataItem::class], version = 1)
abstract class DataDB: RoomDatabase() {
    abstract fun getDataDao(): DataDao
}