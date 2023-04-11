package com.example.projectforschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectforschool.databinding.ActivityDifferenceSquaresBinding
import com.example.projectforschool.databinding.ActivityMainPythagorasBinding
import kotlin.math.pow
import kotlin.math.sqrt

class DifferenceSquares : AppCompatActivity() {

    lateinit var binding: ActivityDifferenceSquaresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDifferenceSquaresBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickSquare(view:View){
        if(!isFieldEmpty()){
            val result = getString(R.string.tvResult) + getResult()
            binding.tvResultSquare.text = result
        }
    }

    private fun isFieldEmpty():Boolean{
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if(edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
        }
        return binding.edA.text.isNullOrEmpty() || binding.edB.text.isNullOrEmpty()
    }

    private fun getResult():String{
        val a: Double
        val b: Double
        val result:Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        result = (a-b)*(a+b)
        return result.toString()
    }
}