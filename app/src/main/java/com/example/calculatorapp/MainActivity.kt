package com.example.calculatorapp

import android.os.Bundle
import android.widget.Toast

import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val result = findViewById<TextView>(R.id.result)

        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)

        buttonAdd.setOnClickListener {
            calculate(number1.text.toString(), number2.text.toString(), "add", result)
        }

        buttonSubtract.setOnClickListener {
            calculate(number1.text.toString(), number2.text.toString(), "subtract", result)
        }

        buttonMultiply.setOnClickListener {
            calculate(number1.text.toString(), number2.text.toString(), "multiply", result)
        }

        buttonDivide.setOnClickListener {
            calculate(number1.text.toString(), number2.text.toString(), "divide", result)
        }
    }

    private fun calculate(num1: String, num2: String, operation: String, result: TextView) {
        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val number1 = num1.toDouble()
        val number2 = num2.toDouble()
        val output: Double

        when (operation) {
            "add" -> output = number1 + number2
            "subtract" -> output = number1 - number2
            "multiply" -> output = number1 * number2
            "divide" -> {
                if (number2 != 0.0) {
                    output = number1 / number2
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> return
        }

        result.text = "Result: $output"
    }
}