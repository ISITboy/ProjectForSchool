package com.example.projectforschool

import android.animation.ValueAnimator.INFINITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.projectforschool.databinding.ActivityMainPythagorasBinding
import com.example.projectforschool.databinding.ActivityQuadraticEquationBinding
import kotlin.math.pow
import kotlin.math.sqrt

class quadraticEquation : AppCompatActivity() {
    lateinit var binding: ActivityQuadraticEquationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuadraticEquationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    private fun isFieldEmpty():Boolean{
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if(edA.text.toString().toInt()==0) edA.error = "Значение А должно быть не равно 0"
            if(edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
            if(edC.text.isNullOrEmpty()) edC.error = "Поле должно быть заполнено"

        }
        return binding.edA.text.isNullOrEmpty() || binding.edB.text.isNullOrEmpty()
                || binding.edC.text.isNullOrEmpty()
    }


    fun onClickResult(view: View){
        binding.apply {
            if(!isFieldEmpty()) {
                var result:String=""
                val a = edA.text.toString().toDouble()
                val b = edB.text.toString().toDouble()
                when (findDiscriminant()) {
                    0 -> result = ((-b) / (2 * a)).toString()
                    in Int.MIN_VALUE..-1 ->  result = "Решений нет"
                    in 1..Int.MAX_VALUE -> {
                        val x1 = ((-b)+ sqrt(findDiscriminant().toDouble()))/(2*a)
                        val x2 = ((-b)- sqrt(findDiscriminant().toDouble()))/(2*a)
                        result= "x1 = $x1; x2 = $x2"
                    }
                }
                Log.d("MyLog","result = $result")
                binding.tvResultQuadratic.text = result
            }
        }
    }

    private fun findDiscriminant():Int{
        binding.apply {
            val a = edA.text.toString().toDouble()
            val b = edB.text.toString().toDouble()
            val c = edC.text.toString().toDouble()
            val D = b.pow(2) +(-4)*a*c
            Log.d("MyLog","$D")
            return D.toInt()
        }
    }

}