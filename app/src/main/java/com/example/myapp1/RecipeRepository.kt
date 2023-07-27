package com.example.myapp1
import androidx.lifecycle.LiveData

class RecipeRepository(private val recipeDao: RecipeDAO) {

    val allRecipes: LiveData<List<Recipe>> = recipeDao.getAllRecipes()

    suspend fun insert(recipe: Recipe) {
        recipeDao.insert(recipe)
    }

    suspend fun insertAll(recipes: List<Recipe>) {
        recipeDao.insertAll(recipes)
    }
}
