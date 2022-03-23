package com.example.challenge_dogs.data.services

import com.example.challenge_dogs.data.api.DogApi
import com.example.challenge_dogs.data.dao.DogDao
import com.example.challenge_dogs.data.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(
        private val db:DogDao,
        private val api:DogApi
){

    suspend fun getDogsLocal():List<Dog>{
        return withContext(Dispatchers.IO){
            db.getAll()
        }
    }

    suspend fun getDogsRemote():List<Dog>{
        return withContext(Dispatchers.IO){
            val response = api.getDogs()
            response.body().let { dogs->
                if (dogs != null )
                    db.updateData(dogs)
            }
            db.getAll()
        }
    }

}