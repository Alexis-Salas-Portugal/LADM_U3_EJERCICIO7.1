package com.example.ladm_u3_ejercicio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
    }
}