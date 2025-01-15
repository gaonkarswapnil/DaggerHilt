package com.example.dihilt.mvvm.model.remote

import com.example.dihilt.mvvm.model.response.DataItem
import com.example.dihilt.mvvm.utils.Constant.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getData(): Response<List<DataItem>>
}