package com.example.biodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton

class About : AppCompatActivity() {

    private lateinit var button : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        button = findViewById(R.id.btn_kembali_about)
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
