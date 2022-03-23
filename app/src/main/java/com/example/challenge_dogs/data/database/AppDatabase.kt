package com.example.challenge_dogs.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.challenge_dogs.data.dao.DogDao
import com.example.challenge_dogs.data.model.Dog

@Database (
        entities = [Dog::class ],
        version = 1
        )
abstract class AppDatabase :RoomDatabase(){
    abstract fun dogDao(): DogDao
}