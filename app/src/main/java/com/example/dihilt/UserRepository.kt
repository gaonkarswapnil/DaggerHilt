package com.example.dihilt

import android.util.Log
import com.example.dihilt.Constant.TAG
import javax.inject.Inject

interface UserRepository{
    fun saveUser(email: String, password: String)
}

class SQLRepository @Inject constructor(private val loggerService: LoggerService): UserRepository{
    override fun saveUser(email: String, password: String){
        loggerService.logger("User Saved to DB");
    }
}

class FirebaseRepository: UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved to Firebase")
    }

}