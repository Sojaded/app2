import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp1.RecipeAdapter
import com.example.myapp1.RecipeViewModel
import com.example.myapp1.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {
    private lateinit var viewModel: RecipeViewModel
    private lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        // Insert example recipes when the app starts (for demonstration purposes)
        insertExampleRecipes()

        val adapter = RecipeAdapter(emptyList()) { selectedRecipe ->
            // Handle click on a recipe item
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.allRecipes.observe(this, { recipes ->
            adapter.recipes = recipes
            adapter.notifyDataSetChanged()
        })

        binding.addButton.setOnClickListener {
            showAddRecipeDialog()
        }
    }

    private fun showAddRecipeDialog() {
        TODO("Not yet implemented")
    }

    private fun insertExampleRecipes() {
        // Check if there are any existing recipes in the database
        val existingRecipes = viewModel.allRecipes.value
        if (existingRecipes == null || existingRecipes.isEmpty()) {
            // Insert example recipes into the database
            val exampleRecipes = listOf(
                Recipe(
                    title = "Pasta Carbonara",
                    ingredients = "Spaghetti, Eggs, Bacon, Parmesan Cheese, Black Pepper",
                    instructions = "1. Cook spaghetti according to package instructions.\n" +
                            "2. Whisk eggs, add cheese and black pepper.\n" +
                            "3. Cook bacon and mix with the egg mixture.\n" +
                            "4. Combine cooked pasta and egg mixture.\n" +
                            "5. Serve immediately.",
                    imageUrl = "https://example.com/image_url_1"
                ),
                Recipe(
                    title = "Chocolate Chip Cookies",
                    ingredients = "Butter, Brown Sugar, White Sugar, Eggs, Vanilla Extract, " +
                            "All-Purpose Flour, Baking Soda, Salt, Chocolate Chips",
                    instructions = "1. Preheat oven to 375°F (190°C).\n" +
                            "2. Cream together butter, brown sugar, and white sugar.\n" +
                            "3. Beat in eggs and vanilla extract.\n" +
                            "4. In a separate bowl, mix flour, baking soda, and salt.\n" +
                            "5. Combine wet and dry ingredients, then add chocolate chips.\n" +
                            "6. Drop spoonfuls of dough onto baking sheets.\n" +
                            "7. Bake for 9-11 minutes.\n" +
                            "8. Cool on baking sheets for a few minutes, then transfer to wire racks.",
                    imageUrl = "https://example.com/image_url_2"
                ),
                // Add more recipes as needed
                Recipe(
                    title = "Classic Margherita Pizza",
                    ingredients = "Pizza Dough, Tomato Sauce, Fresh Mozzarella, Fresh Basil, Olive Oil",
                    instructions = "1. Preheat oven to 475°F (245°C).\n" +
                            "2. Roll out pizza dough and place on a baking sheet.\n" +
                            "3. Spread tomato sauce on the dough.\n" +
                            "4. Add slices of fresh mozzarella on top.\n" +
                            "5. Bake for 12-15 minutes or until the crust is golden and cheese is bubbly.\n" +
                            "6. Remove from the oven and top with fresh basil leaves.\n" +
                            "7. Drizzle with olive oil before serving.",
                    imageUrl = "https://example.com/image_url_3"
                ),
                Recipe(
                    title = "Chicken Stir-Fry",
                    ingredients = "Chicken Breast, Mixed Vegetables, Soy Sauce, Ginger, Garlic, Sesame Oil",
                    instructions = "1. Cut chicken into bite-sized pieces and marinate with soy sauce, " +
                            "ginger, and garlic.\n" +
                            "2. Heat sesame oil in a wok or large skillet.\n" +
                            "3. Add chicken and cook until browned.\n" +
                            "4. Add mixed vegetables and stir-fry until tender-crisp.\n" +
                            "5. Season with additional soy sauce if needed.\n" +
                            "6. Serve over cooked rice or noodles.",
                    imageUrl = "https://example.com/image_url_4"
                ),
                Recipe(
                    title = "Vegetarian Lentil Soup",
                    ingredients = "Lentils, Carrots, Celery, Onion, Garlic, Vegetable Broth, " +
                            "Tomato Paste, Spices",
                    instructions = "1. Chop carrots, celery, and onion.\n" +
                            "2. Sauté vegetables in a large pot with olive oil.\n" +
                            "3. Add minced garlic and cook for another minute.\n" +
                            "4. Rinse lentils and add them to the pot.\n" +
                            "5. Pour in vegetable broth and add tomato paste.\n" +
                            "6. Season with your favorite spices (e.g., thyme, cumin, paprika).\n" +
                            "7. Bring to a boil, then reduce heat and simmer until lentils are tender.\n" +
                            "8. Adjust seasoning and serve hot.",
                    imageUrl = "https://example.com/image_url_5"
                ),
                Recipe(
                    title = "Mango Salsa",
                    ingredients = "Mango, Red Onion, Jalapeño, Cilantro, Lime Juice, Salt",
                    instructions = "1. Dice mango, red onion, and jalapeño.\n" +
                            "2. Finely chop cilantro.\n" +
                            "3. Combine all ingredients in a bowl.\n" +
                            "4. Squeeze fresh lime juice over the mixture.\n" +
                            "5. Season with salt to taste.\n" +
                            "6. Stir everything together and refrigerate for at least 30 minutes.\n" +
                            "7. Serve as a refreshing salsa with tortilla chips or as a topping for grilled meats.",
                    imageUrl = "https://example.com/image_url_6"
                ),
                Recipe(
                    title = "Baked Salmon",
                    ingredients = "Salmon Fillet, Lemon, Dijon Mustard, Honey, Olive Oil, " +
                            "Garlic Powder, Paprika",
                    instructions = "1. Preheat oven to 375°F (190°C).\n" +
                            "2. In a small bowl, mix Dijon mustard, honey, olive oil, garlic powder, " +
                            "and paprika to make the glaze.\n" +
                            "3. Place salmon fillet on a baking sheet lined with parchment paper.\n" +
                            "4. Drizzle the glaze over the salmon.\n" +
                            "5. Slice a lemon and place lemon slices on top of the salmon.\n" +
                            "6. Bake for 12-15 minutes or until the salmon is cooked through.\n" +
                            "7. Serve with your favorite side dishes.",
                    imageUrl = "https://example.com/image_url_7"
                ),
                Recipe(
                    title = "Avocado Toast",
                    ingredients = "Avocado, Bread, Lemon Juice, Red Pepper Flakes, Salt, " +
                            "Extra Virgin Olive Oil",
                    instructions = "1. Toast slices of bread until golden and crispy.\n" +
                            "2. In a bowl, mash ripe avocado with a fork.\n" +
                            "3. Add a squeeze of lemon juice, a pinch of red pepper flakes, and salt.\n" +
                            "4. Mix everything together until creamy.\n" +
                            "5. Spread the avocado mixture on the toasted bread.\n" +
                            "6. Drizzle with extra virgin olive oil.\n" +
                            "7. Sprinkle with additional red pepper flakes for extra kick.",
                    imageUrl = "https://example.com/image_url_8"
                ),
                Recipe(
                    title = "Chicken Fajitas",
                    ingredients = "Chicken Thighs, Bell Peppers, Onion, Fajita Seasoning, " +
                            "Tortillas",
                    instructions = "1. Slice chicken thighs into thin strips.\n" +
                            "2. Cut bell peppers and onion into strips.\n" +
                            "3. In a large skillet, cook chicken until browned and cooked through.\n" +
                            "4. Add bell peppers and onion to the skillet.\n" +
                            "5. Sprinkle fajita seasoning over the mixture and stir well.\n" +
                            "6. Cook until vegetables are tender-crisp.\n" +
                            "7. Serve with warm tortillas and your favorite toppings (e.g., salsa, guacamole).",
                    imageUrl = "https://example.com/image_url_9"
                ),
                Recipe(
                    title = "Greek Salad",
                    ingredients = "Cucumbers, Tomatoes, Red Onion, Kalamata Olives, Feta Cheese, " +
                            "Olive Oil, Red Wine Vinegar, Oregano",
                    instructions = "1. Chop cucumbers, tomatoes, and red onion.\n" +
                            "2. Pit and slice Kalamata olives.\n" +
                            "3. Crumble feta cheese.\n" +
                            "4. Combine all ingredients in a large bowl.\n" +
                            "5. Drizzle with olive oil and red wine vinegar.\n" +
                            "6. Sprinkle with dried oregano.\n" +
                            "7. Toss everything together until well combined.\n" +
                            "8. Serve chilled as a refreshing salad.",
                    imageUrl = "https://example.com/image_url_10"
                )
            )

            viewModel.insertAll(exampleRecipes)
        }
    }

    // Rest of the code remains unchanged
}