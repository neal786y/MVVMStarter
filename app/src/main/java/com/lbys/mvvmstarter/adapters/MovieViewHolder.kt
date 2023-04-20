package com.lbys.mvvmstarter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.lbys.mvvmstarter.R
import com.lbys.mvvmstarter.databinding.ItemMovieBinding
import com.lbys.mvvmstarter.models.Movie

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movieTitle.text = movie.title
        binding.movieDescription.text = movie.description

        Glide.with(itemView.context)
            .load(movie.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions().placeholder(R.drawable.placeholder))
            .into(binding.movieImage)
    }

    companion object {
        fun from(parent: ViewGroup): MovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
            return MovieViewHolder(binding)
        }
    }
}
