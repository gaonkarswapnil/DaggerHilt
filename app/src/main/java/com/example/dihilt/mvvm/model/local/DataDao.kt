package com.example.dihilt.mvvm.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dihilt.mvvm.model.response.DataItem
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {
    @Insert
    suspend fun insertData(dataItem: List<DataItem>)

    @Query("select * from product")
    fun showData(): Flow<List<DataItem>>
}