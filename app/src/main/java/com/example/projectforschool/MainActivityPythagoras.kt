package com.example.projectforschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectforschool.databinding.ActivityMainBinding
import com.example.projectforschool.databinding.ActivityMainPythagorasBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivityPythagoras : AppCompatActivity() {

    lateinit var binding:ActivityMainPythagorasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPythagorasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    fun onClickResult(view: View){
        if(!isFieldEmpty()){
            val result = getString(R.string.tvResult) + getResult()
            binding.tvResult.text = result
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
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt((a.pow(2)+b.pow(2))).toString()
    }

}