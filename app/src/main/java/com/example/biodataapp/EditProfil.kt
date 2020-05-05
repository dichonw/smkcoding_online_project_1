package com.example.biodataapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_edit_profil.*

class EditProfil : AppCompatActivity() {

//    private lateinit var button : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

//        button = findViewById(R.id.btn_kembali_editProfil)
//        button.setOnClickListener{
//            startActivity(Intent(this, Profil::class.java))
//        }

        //menerima data yang dikirimkan dari ProfilActivity.kt
        val intentData = intent.extras
        val namaUser = intentData.getString("nama")
        //set edittext dengan data yang dikirimkan tadi
        edtProfilName.setText(namaUser)
        //memberikan action click ke tombol Simpan
        btnEditSave.setOnClickListener { saveData() }
    }

        //mengirimkan kembali ke ProfilActivity.kt
        private fun saveData(){
            val namaEdit = edtProfilName.text.toString()
            if (!namaEdit.isEmpty()) {
        //jika editText namaEdit tidak kosong, maka kirimkan value nya ke ProfilActivity, dan beri tanda RESULT_OK
                    val result = Intent()
                    result.putExtra("nama", namaEdit)
                    setResult(Activity.RESULT_OK, result)
                } else {
        //jika editText namaEdit kosong, maka kirimkan tanda RESULT_CANCELED
                    setResult(Activity.RESULT_CANCELED)
                }
                finish()
            }
}
