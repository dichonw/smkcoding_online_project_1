package com.example.biodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton

class FormBiodata : AppCompatActivity() {

    private lateinit var button : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_biodata)

        button = findViewById(R.id.btn_kembali_form)
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
