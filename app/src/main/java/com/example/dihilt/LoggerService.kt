package com.example.dihilt

import android.util.Log
import com.example.dihilt.Constant.TAG
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggerService @Inject constructor() {
    fun logger(message: String){
        Log.d(TAG, message)
    }
}