package com.example.myapp1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter( var recipes: List<Recipe>, private val onItemClick: (Recipe) -> Unit) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemRecipeBinding.inflate(inflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    inner class RecipeViewHolder(private val binding: ListItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.Recipe = recipe
            binding.executePendingBindings()

            // Load image with a library like Glide/Picasso
            if (!recipe.imageUrl.isNullOrEmpty()) {
                Glide.with(binding.imageView).load(recipe.imageUrl).into(binding.imageView)
            } else {
                // Set a placeholder image if there's no URL available
                binding.imageView.setImageResource(R.drawable.placeholder_image)
            }

            binding.root.setOnClickListener { onItemClick(recipe) }
        }
    }
}
