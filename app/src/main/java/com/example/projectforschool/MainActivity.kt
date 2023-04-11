package com.example.projectforschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickGoPythagoras(view:View){
        val i = Intent(this,MainActivityPythagoras::class.java);
        startActivity(i)
    }
    fun onClickQuadratic(view:View){
        val i = Intent(this,quadraticEquation::class.java);
        startActivity(i)
    }
    fun onClickSquares(view :View){
        val i = Intent(this,DifferenceSquares::class.java);
        startActivity(i)
    }
}