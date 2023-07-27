package com.example.myapp1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RecipeRepository
    val getAllRecipes: LiveData<List<Recipe>>

    init {
        val recipeDao = RecipeDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(recipeDao)
        getAllRecipes = repository.allRecipes


        fun allRecipes(): LiveData<List<Recipe>> {
            return recipeDao.AllRecipes().asLiveData()
        }


        fun insert(recipe: Recipe) = viewModelScope.launch {
            repository.insert(recipe)
        }

        fun insertAll(recipes: List<Recipe>) = viewModelScope.launch {
            repository.insertAll(recipes)
        }

        fun update(recipe: Recipe) {
            viewModelScope.launch(Dispatchers.IO) {
                recipeDao.update(recipe)
            }
        }

        fun delete(recipe: Recipe) {
            viewModelScope.launch(Dispatchers.IO) {
                recipeDao.delete(recipe)
            }
        }


    }
}