package com.example.myapp1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recipe")
 class Recipe {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val ingredients: String,
    val instructions: String,
    val imageUrl: String?
}