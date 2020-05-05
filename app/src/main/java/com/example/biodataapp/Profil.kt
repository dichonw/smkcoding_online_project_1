package com.example.biodataapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast


class Profil : AppCompatActivity() {

    private lateinit var buttonBeranda : Button
    private lateinit var button : ImageButton
    companion object {
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        button = findViewById(R.id.btn_kembali_profil)
        button.setOnClickListener{
            startActivity(Intent(this, FormBiodata::class.java))
        }

        buttonBeranda = findViewById(R.id.btnAbout)
        buttonBeranda.setOnClickListener{
            startActivity(Intent(this, About::class.java))
        }

        ambilData()
        btnEditName.setOnClickListener { navigasiKeEditProfil() }
        btnCall.setOnClickListener { dialPhoneNumber(txtTelp.text.toString()) }


    }

    private fun ambilData(){
        val bundle = intent.extras
        val nama = bundle.getString("nama")
        val gender = bundle.getString("gender")
        val umur = bundle.getString("umur")
        val email = bundle.getString("email")
        val telp = bundle.getString("telp")
        val alamat = bundle.getString("alamat")
        txtName.text = nama
        txtGender.text = gender
        txtUmur.text = umur
        txtEmail.text = email
        txtTelp.text = telp
        txtAddress.text = alamat
    }

    //fungsi untuk berpindah ke EditProfilActivity
    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfil::class.java)
        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
            }else{
                Toast.makeText(this, "Edit Profil Gagal",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply { data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
