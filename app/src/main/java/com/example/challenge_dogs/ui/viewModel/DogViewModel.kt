package com.example.challenge_dogs.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge_dogs.data.model.Dog
import com.example.challenge_dogs.data.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val repository: DogRepository
)  : ViewModel(){

    private val _listDog = MutableLiveData <List<Dog>> ()
    val listDog :LiveData<List<Dog>> get () = _listDog

    fun getDogs(){
        viewModelScope.launch {
            val response = repository.getDogs()
            _listDog.postValue(response)
        }
    }

}