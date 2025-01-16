package com.example.dihilt.mvvm.di

import com.example.dihilt.mvvm.model.Retrofit
import com.example.dihilt.mvvm.model.RoomDB
import com.example.dihilt.mvvm.model.repository.UserDB
import com.example.dihilt.mvvm.model.repository.UserInterface
import com.example.dihilt.mvvm.model.repository.UserRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRepoModule {

    @Provides
    @Singleton
    @Retrofit
    fun provideUserRepo(userRetrofit: UserRetrofit): UserInterface{
        return userRetrofit
    }


    @Provides
    @Singleton
    @RoomDB
    fun provideUserDB(userDB: UserDB): UserInterface{
        return userDB
    }
}