package com.example.hw7_q1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        binding.deleteButton.setOnClickListener {
            binding.calculateView.text = ""
            Toast.makeText(this, "DELETE", Toast.LENGTH_SHORT).show()
        }
        binding.alike.setOnClickListener {

            if(binding.calculateView.text.contains("✖")){
                multiplication()
            }
            if(binding.calculateView.text.contains("+")){
               sum()
            }
            if(binding.calculateView.text.contains("-")){
                minus()
            }
            if(binding.calculateView.text.contains("÷")){
            div()
        }


        }

}

    fun sum(){
        var entry = binding.calculateView.text
        var entryList = entry.split("+")
        var secondEnteredNumber = entryList[1].split("=")
        var result =  entryList[0].toDouble()+ secondEnteredNumber[0].toDouble()
        binding.calculateView.text = result.toString()
    }

    fun minus(){
        var entry = binding.calculateView.text
        var entryList = entry.split("-")
        var secondEnteredNumber = entryList[1].split("=")
        var result = entryList[0].toDouble() - secondEnteredNumber[0].toDouble()
        binding.calculateView.text = result.toString()
    }
    fun div(){
        var entry = binding.calculateView.text
        var entryList = entry.split("÷")
        var secondEnteredNumber = entryList[1].split("=")
        var result =entryList[0].toDouble() / secondEnteredNumber[0].toDouble()
        binding.calculateView.text = result.toString()
    }
    fun multiplication(){
        var entry = binding.calculateView.text
        var entryList = entry.split("✖")
        var secondEnteredNumber = entryList[1].split("=")
        var result =entryList[0].toDouble() * secondEnteredNumber[0].toDouble()
        binding.calculateView.text = result.toString()
    }

    fun buttonClick (view: View){
        binding.calculateView.text = binding.calculateView.text.toString() + (view as Button).text.toString()
        Toast.makeText(this, (view as Button).text, Toast.LENGTH_SHORT).show()
    }

}