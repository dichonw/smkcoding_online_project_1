package com.example.biodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_about.*

class About : AppCompatActivity() {

    private lateinit var button : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        button = findViewById(R.id.btn_kembali_about)
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnCall.setOnClickListener { dialPhoneNumber(txtTelp.text.toString()) }

    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
