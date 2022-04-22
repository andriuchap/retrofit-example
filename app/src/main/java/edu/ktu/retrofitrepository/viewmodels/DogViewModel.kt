package edu.ktu.retrofitrepository.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ktu.retrofitrepository.data.repository.DogRepository
import edu.ktu.retrofitrepository.models.Dog
import kotlinx.coroutines.launch
import java.lang.Exception

class DogViewModel(val repository: DogRepository) : ViewModel() {

    private val _dogs = MutableLiveData<List<Dog>>()
    val dogs: LiveData<List<Dog>>
        get() = _dogs

    fun getDogs() {
        viewModelScope.launch {
            try {
                _dogs.value = repository.getDogs()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getDog() {
        viewModelScope.launch {
            try {
                _dogs.value = listOf(repository.getDog(2))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    init {
        getDog()
    }
}