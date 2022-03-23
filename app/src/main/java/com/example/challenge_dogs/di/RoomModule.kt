package com.example.challenge_dogs.di

import android.content.Context
import androidx.room.Room
import com.example.challenge_dogs.BuildConfig
import com.example.challenge_dogs.data.dao.DogDao
import com.example.challenge_dogs.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
           BuildConfig.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDogDao(appDatabase: AppDatabase): DogDao {
        return appDatabase.dogDao()
    }

}