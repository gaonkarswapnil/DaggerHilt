package com.example.dihilt.mvvm.di

import android.content.Context
import androidx.room.Room
import com.example.dihilt.mvvm.model.local.DataDB
import com.example.dihilt.mvvm.model.local.DataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): DataDB{
        return Room.databaseBuilder(
            context.applicationContext,
            DataDB::class.java,
            "productsDB"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDataDao(db: DataDB): DataDao{
        return db.getDataDao()
    }
}