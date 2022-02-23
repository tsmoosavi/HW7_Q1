package com.example.hw7_q1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hw7_q1.databinding.ActivityMainBinding

var firstNumber: Double = 0.0
var secondNumber: Double = 0.0
var thirdNumber: Double = 0.0

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonList = arrayListOf<Button>(
            binding.zeroButton,
            binding.oneButton,
            binding.towButton,
            binding.threeButton,
            binding.fourButton,
            binding.fiveButton,
            binding.sixButton,
            binding.sevenButton,
            binding.eightButton,
            binding.nineButton
        )
        val oprationList = arrayListOf<Button>(
            binding.deleteButton,
            binding.alike,
            binding.division,
            binding.multiplicationButton,
            binding.submission,
            binding.total,
            binding.dotButton,
        )
        binding.calculateView.text = binding.fourButton.text.toString() + binding.sevenButton.text .toString() // "+" dosenot work
        for (button in buttonList) {
            button.setOnClickListener {
                binding.calculateView.text.toString() += button.text.toString()

                firstNumber = binding.calculateView.text.toString().toDouble()
                secondNumber = binding.calculateView.text.toString().toDouble()


                Toast.makeText(this, button.text, Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun delete() {
        binding.deleteButton.setOnClickListener {
            binding.calculateView.clearComposingText()
        }

    }
}