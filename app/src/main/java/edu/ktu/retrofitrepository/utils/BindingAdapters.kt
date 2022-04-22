package edu.ktu.retrofitrepository.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.ktu.retrofitrepository.adapters.DogAdapter
import edu.ktu.retrofitrepository.models.Dog

@BindingAdapter("dogImage")
fun ImageView.setDogImage(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}

@BindingAdapter("dogs")
fun RecyclerView.setDogs(dogs: List<Dog>?) {
    dogs?.let { (adapter as DogAdapter).submitList(dogs) }
}