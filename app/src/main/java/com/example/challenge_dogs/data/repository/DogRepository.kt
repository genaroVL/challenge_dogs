package com.example.challenge_dogs.data.repository

import android.content.Context
import com.example.challenge_dogs.data.model.Dog
import com.example.challenge_dogs.data.services.DogService
import com.example.challenge_dogs.data.utils.NetworkHelper.isNetworkAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val service:DogService,
    @ApplicationContext private val context:Context
) {
    suspend fun getDogs(): List<Dog> {
     val response:List<Dog> =
                    if ( isNetworkAvailable( context ))
                           service.getDogsRemote()
                    else
                           service.getDogsLocal()
     return  response
    }
}