package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textOutput: TextView = findViewById(R.id.textView)
        val textHint:TextView = findViewById(R.id.textHint)
        val buttonGuess: Button = findViewById(R.id.buttonGuess)
        val buttonReset:Button = findViewById(R.id.buttonReset)
        val buttonHint:Button = findViewById(R.id.buttonHint)
        val editText: EditText = findViewById(R.id.editText)

        var random:Int = (1..1000).random()

        buttonGuess.setOnClickListener(){
            if (editText.text.isEmpty()) {
                textOutput.text = "Input something"
            } else if (!editText.text.isDigitsOnly()) {
                textOutput.text = "Only integer input"

            } else {
                val number: Int = editText.text.toString().toInt()
                textOutput.text = "you're quite smart $number"

                when {
                    number < random -> {
                        textOutput.text = "guess higher"
                    }
                    number > random -> {
                        textOutput.text = "guess lower"
                    }
                    else -> {
                        textOutput.text = "Correct !!!"
                    }
                }

            }
        }

        buttonReset.setOnClickListener(){
            textHint.text = ""
            textOutput.text = "Guess the number"
            random = (1..1000).random()
        }

        buttonHint.setOnClickListener {
            textHint.text = "$random"
        }
    }
}