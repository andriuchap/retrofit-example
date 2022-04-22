package edu.ktu.retrofitrepository.models

import com.squareup.moshi.*

data class Dog (
    val dogId: Int,
    val name: String,
    val age: Int,
    val breed: DogBreed,
    val imageUrl: String
)

enum class DogBreed(val breedName: String){
    GERMAN_SHEPHERD("German Shepherd"),
    LABRADOR_RETRIEVER("Labrador Retriever"),
    GOLDEN_RETRIEVER("Golden Retriever");

    companion object {
        private val breedValues : Array<DogBreed> by lazy {
            values()
        }

        fun getFromName(name: String) : DogBreed {
            return when(name){
                "German Shepherd" -> GERMAN_SHEPHERD
                "Labrador Retriever" -> LABRADOR_RETRIEVER
                "Golden Retriever" -> GOLDEN_RETRIEVER
                else -> GERMAN_SHEPHERD
            }
        }
    }
}

class DogBreedAdapter {
    /*@FromJson fun fromJson(jsonReader: JsonReader, delegate: JsonAdapter<DogBreed>): DogBreed {
        val value = jsonReader.nextString()
        return DogBreed.getFromName(value)
    }*/

    @ToJson fun toJson(breed: DogBreed): String {
        return breed.name
    }

    @FromJson fun fromJson(breed: String): DogBreed {
        return DogBreed.getFromName(breed)
    }
}