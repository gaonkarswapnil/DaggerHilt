package com.example.dihilt.mvvm.model.repository

import androidx.lifecycle.asFlow
import androidx.room.PrimaryKey
import com.example.dihilt.mvvm.di.RetrofitHelper
import com.example.dihilt.mvvm.model.Retrofit
import com.example.dihilt.mvvm.model.local.DataDB
import com.example.dihilt.mvvm.model.local.DataDao
import com.example.dihilt.mvvm.model.remote.ApiService
import com.example.dihilt.mvvm.model.response.DataItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface UserInterface {
    suspend fun getData(): Flow<Result<List<DataItem>>>
}

class UserRetrofit @Inject constructor(
    private val apiService: ApiService,
    private val roomDB: DataDao
) : UserInterface{

    override suspend fun getData(): Flow<Result<List<DataItem>>> = flow {
        val response = apiService.getData()

        if(response.isSuccessful){
            response.body()?.let {
                roomDB.insertData(it)
                emit(Result.success(it))
            }
        }else{
            emit(Result.failure(Exception("Error: ${response.code()}")))
        }
    }

}

class UserDB @Inject constructor(
    private val roomDB: DataDao
): UserInterface{
    override suspend fun getData(): Flow<Result<List<DataItem>>> = roomDB.showData()
        .map { items ->
            Result.success(items)
        }
        .catch { e ->
            emit(Result.failure(e))
        }
}