package com.example.myapp1

import androidx.lifecycle.LiveData
import androidx.room.*

interface RecipeDAO {

    @Update
    suspend fun update(recipe:Recipe)

    @Delete
    suspend fun delete(recipe:Recipe)

    @Query("SELECT * FROM recipe")
    suspend fun getAllRecipes():LiveData<List<Recipe>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertAll(recipes: List<Recipe>)
}