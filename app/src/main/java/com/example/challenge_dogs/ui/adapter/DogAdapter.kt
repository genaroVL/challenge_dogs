package com.example.challenge_dogs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_dogs.R
import com.example.challenge_dogs.data.model.Dog
import com.example.challenge_dogs.data.utils.load
import com.example.challenge_dogs.databinding.ItemDogBinding

class DogAdapter(val dogs:List<Dog>) :RecyclerView.Adapter<DogAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dog,parent,false)
        return ViewHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dogs[position])

    override fun getItemCount(): Int = dogs.size

    class  ViewHolder( view: View,val context:Context):RecyclerView.ViewHolder(view){

        private val binding = ItemDogBinding.bind(view)

        fun bind( dog :Dog ) = with(binding) {
            tvDogName.text        = dog.name
            tvDogDescription.text = dog.description
            tvDogAge.text         = context.getString(R.string.dog_age_with_years,dog.age)
            imvDog.load(dog.url)
        }
    }

}