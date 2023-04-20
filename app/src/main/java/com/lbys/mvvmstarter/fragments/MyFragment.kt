package com.lbys.mvvmstarter.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lbys.mvvmstarter.R
import com.lbys.mvvmstarter.adapters.MovieAdapter
import com.lbys.mvvmstarter.databinding.FragmentMyBinding
import com.lbys.mvvmstarter.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MyFragment : Fragment() {private lateinit var binding: FragmentMyBinding

    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE
        val movieAdapter = MovieAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = movieAdapter

        viewModel.loading.observe(requireActivity()) {
            if (it) binding.progressBar.visibility =
                View.VISIBLE else binding.progressBar.visibility = View.GONE
        }

        viewModel.movies.observe(requireActivity(), {
            //Update UI
            movieAdapter.updateMovies(it)
        })

        viewModel.searchMovies("Marvel")
    }
}
