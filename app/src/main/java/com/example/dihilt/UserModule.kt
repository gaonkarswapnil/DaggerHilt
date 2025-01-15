package com.example.dihilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
class UserModule {

    @Provides
//    @ActivityScoped
    @Named("firebase")
    fun provideFirebaseRepository():UserRepository{
        return FirebaseRepository()
    }


    @Provides
//    @ActivityScoped
    @ForSQL
    fun provideSQLRepository(sqlRepository: SQLRepository): UserRepository{
        return sqlRepository
    }

//    @Binds
//    abstract fun provideUserRepository(sqlRepository: SQLRepository): UserRepository
}