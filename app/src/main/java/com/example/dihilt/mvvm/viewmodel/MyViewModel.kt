package com.example.dihilt.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dihilt.mvvm.model.Retrofit
import com.example.dihilt.mvvm.model.RoomDB
import com.example.dihilt.mvvm.model.repository.UserInterface
import com.example.dihilt.mvvm.model.response.DataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    @RoomDB private val repository: UserInterface
): ViewModel() {
    fun getData(): LiveData<Result<List<DataItem>>>{
        val getDataResponse = MutableLiveData<Result<List<DataItem>>>()

        viewModelScope.launch {
            repository.getData().collect{ result ->
                getDataResponse.postValue(result)
            }
        }

        return getDataResponse
    }
}