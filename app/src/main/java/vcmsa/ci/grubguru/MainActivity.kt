package vcmsa.ci.grubguru

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        // Translating UI stuff to kt
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.foodButton)
        val resetButton = findViewById<Button>(R.id.clearButton)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)

            // Button Click actions for Meal Suggestion
        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()

            // Variable to hold the suggestion
            var suggestion: String = ""

            // If statement for different times of day
            if (timeOfDay == "morning") {
                val morningOptions = listOf(
                    "How about some eggs and toast? 🍳🍞",
                    "Maybe a smoothie and some granola?",
                    "Fancy some pancakes?"
                )
                suggestion = morningOptions.random()
            } else if (timeOfDay == "mid-morning") {
                val midMorningOptions = listOf(
                    "Grab a light snack, maybe some fruit? 🍎🍌",
                    "Red pepper and hummus?",
                    "Treat yourself to some cake! I won't tell."
                )
                suggestion = midMorningOptions.random()
            } else if (timeOfDay == "afternoon") {
                val afternoonOptions = listOf(
                    "A sandwich would be great! 🥪",
                    "Wrap for lunch?",
                    "A good salad to leave room for dinner!"
                )
                suggestion = afternoonOptions.random()
            } else if (timeOfDay == "mid-afternoon") {
                val midAfternoonOptions = listOf(
                    "How about some cake or biscuits? 🍰🍪",
                    "A handful of nuts and a smoothie?",
                    "Crackers and tea will make you feel like the Queen right now."
                )
                suggestion = midAfternoonOptions.random()
            } else if (timeOfDay == "dinner") {
                val dinnerOptions = listOf(
                    "Pasta sounds perfect for dinner! 🍝",
                    "Steak, mashed potatoes, veggies. Easy!",
                    "Stir fry with crispy chicken! Have fun with cleaning though"
                )
                suggestion = dinnerOptions.random()
            } else if (timeOfDay == "after dinner") {
                val afterDinnerOptions = listOf(
                    "End the day with ice cream! 🍦",
                    "Can't go wrong with fruit salad. Unless you hate fruits. And salad.",
                    "Have fun with a chocolate bar!"
                )
                suggestion = afterDinnerOptions.random()
            } else {
                suggestion = "Yikers. That's not real time.. try again"
            }

            // Update the TextView with the suggestion
            mealSuggestion.text = suggestion
        }


        // Clear Button to reset Input and Output
            resetButton.setOnClickListener {
                timeInput.text.clear()
                mealSuggestion.text = ""
            }
        }
    }
