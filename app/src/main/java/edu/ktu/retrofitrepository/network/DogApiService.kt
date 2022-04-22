package edu.ktu.retrofitrepository.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import edu.ktu.retrofitrepository.models.Dog
import edu.ktu.retrofitrepository.models.DogBreedAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://vrlab.lt/api/dogs/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).add(DogBreedAdapter()).build()

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(
            BASE_URL
        )
        .build()

interface DogApiService {
    @GET("get")
    suspend fun getDogs(): List<Dog>

    @GET("get")
    suspend fun getDog(@Query("dogId") dogId : Int): Dog
}

object DogApi {
    @Volatile
    private var _instance: DogApiService? = null
    fun getInstance(): DogApiService {
        return _instance ?: synchronized(this) {
            val inst = retrofit.create(DogApiService::class.java)
            _instance = inst
            inst
        }
    }
}