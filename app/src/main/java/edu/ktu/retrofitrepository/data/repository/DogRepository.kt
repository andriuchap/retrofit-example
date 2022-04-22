package edu.ktu.retrofitrepository.data.repository

import edu.ktu.retrofitrepository.network.DogApi

class DogRepository {

    suspend fun getDogs() = DogApi.getInstance().getDogs()

    suspend fun getDog(dogId: Int) = DogApi.getInstance().getDog(dogId)
}