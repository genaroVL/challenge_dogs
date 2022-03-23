package com.example.challenge_dogs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data  class Dog (
                @PrimaryKey (autoGenerate = true)val id:Long,
                @SerializedName("dogName")
                val name:String,
                val description:String,
                val age:Int,
                val url:String
                 )