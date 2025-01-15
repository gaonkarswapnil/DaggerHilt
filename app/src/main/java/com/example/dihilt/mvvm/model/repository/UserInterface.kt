package com.example.dihilt.mvvm.model.repository

import com.example.dihilt.mvvm.di.RetrofitHelper
import com.example.dihilt.mvvm.model.Retrofit
import com.example.dihilt.mvvm.model.remote.ApiService
import com.example.dihilt.mvvm.model.response.DataItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface UserInterface {
    suspend fun getData(): Flow<Result<List<DataItem>>>
}

class UserRetrofit @Inject constructor(
    private val apiService: ApiService
) : UserInterface{

    override suspend fun getData(): Flow<Result<List<DataItem>>> = flow {
        val response = apiService.getData()

        if(response.isSuccessful){
            response.body()?.let {
                emit(Result.success(it))
            }
        }else{
            emit(Result.failure(Exception("Error: ${response.code()}")))
        }
    }

}