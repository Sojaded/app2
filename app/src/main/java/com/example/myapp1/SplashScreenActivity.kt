package com.example.myapp1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash.finish

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Set a delay using Handler to display the splash screen for a few seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity after the delay
            val intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // Splash screen display time in milliseconds (e.g., 2000ms = 2 seconds)
    }
}