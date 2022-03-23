package com.example.challenge_dogs.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.challenge_dogs.data.model.Dog

@Dao
interface DogDao {
    @Query("SELECT * FROM Dog")
    suspend fun getAll():List<Dog>

    @Query("DELETE FROM Dog")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(newDogs: List<Dog>)

    @Transaction
    suspend fun updateData(listDogs:List<Dog>){
        deleteAll()
        insertAll(listDogs)
    }
}