package com.acronymmeaning.example.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.acronymmeaning.example.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userInputFragment = UserInputFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, userInputFragment).commit()
    }
}
