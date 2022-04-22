package edu.ktu.retrofitrepository.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import edu.ktu.retrofitrepository.adapters.DogAdapter
import edu.ktu.retrofitrepository.data.repository.DogRepository
import edu.ktu.retrofitrepository.databinding.FragmentDogBinding
import edu.ktu.retrofitrepository.viewmodels.DogViewModel
import edu.ktu.retrofitrepository.viewmodels.DogViewModelFactory

class DogFragment : Fragment() {

    val viewmodel: DogViewModel by viewModels { DogViewModelFactory(DogRepository()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDogBinding.inflate(inflater)

        val adapter = DogAdapter()
        binding.dogRecyclerView.adapter = adapter

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner

        viewmodel.dogs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewmodel.getDogs()

        return binding.root
    }
}