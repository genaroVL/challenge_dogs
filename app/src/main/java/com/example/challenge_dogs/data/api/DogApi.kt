package com.example.challenge_dogs.data.api

import com.example.challenge_dogs.data.model.Dog
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {
    @GET("dogs")
    suspend fun getDogs() : Response<List<Dog>>
}