package vcmsa.ci.grubguru

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*


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

            //When statement for different times. Like the emojis?
            val suggestion = when (timeOfDay) {
                "morning" -> "How about some eggs and toast? 🍳🍞"
                "mid-morning" -> "Grab a light snack, maybe some fruit? 🍎🍌"
                "afternoon" -> "A sandwich would be great! 🥪"
                "mid-afternoon" -> "How about some cake or biscuits? 🍰🍪"
                "dinner" -> "Pasta sounds perfect for dinner! 🍝"
                "after dinner" -> "End the day with ice cream! 🍦"
                else -> "Yikers. That's not real time.. try again"
            }
            //to print whatever's in the textView.. I think
            mealSuggestion.text = suggestion
        }

        // Clear Button to reset Input and Output
        resetButton.setOnClickListener {
            timeInput.text.clear()
            mealSuggestion.text = ""
        }
    }
}