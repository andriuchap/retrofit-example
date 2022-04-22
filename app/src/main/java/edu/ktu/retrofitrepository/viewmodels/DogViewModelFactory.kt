package edu.ktu.retrofitrepository.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.ktu.retrofitrepository.data.repository.DogRepository
import java.lang.IllegalArgumentException

class DogViewModelFactory(val repository: DogRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DogViewModel::class.java)) {
            return DogViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}