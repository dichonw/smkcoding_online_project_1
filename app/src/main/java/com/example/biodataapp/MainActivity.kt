package com.example.biodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import org.jetbrains.anko.toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_form)
        button.setOnClickListener{
            startActivity(Intent(this, FormBiodata::class.java))
        }

        button = findViewById(R.id.btn_about)
        button.setOnClickListener{
            startActivity(Intent(this, About::class.java))
        }

    }
}
