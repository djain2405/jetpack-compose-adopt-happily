package com.example.androiddevchallenge.dogListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.DogRepository
import kotlinx.coroutines.launch

class DogListingViewModel : ViewModel() {
    private val repository: DogRepository = DogRepository()
    private val _dogsList = MutableLiveData<List<Dog>>()
    val dogsList: LiveData<List<Dog>>
        get() = _dogsList

    init {
        viewModelScope.launch {
            _dogsList.value = repository.getDogs()
        }
    }
}