package com.example.biodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_from_biodata.*

class FormBiodata : AppCompatActivity() {

    private lateinit var button : ImageButton

    //inisialisasi variabel global untuk menampung data inputan user
    private var namaInput : String = ""
    private var genderInput : String = ""
    private var umurInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_biodata)

        button = findViewById(R.id.btn_kembali_form)
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        //set data spinner Gender
        setDataSpinnerGender()

        //memberi click listener ke tombol Save.
        //jika tombol save ditekan, maka akan menjalankan method
        validasiInput()
        btnSave.setOnClickListener { validasiInput() }
    }

        //fungsi untuk set data pada spinner gender dengan string-array jenis kelamin
        private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }

        //fungsi untuk melakukan validasi input
        private fun validasiInput(){
            //mendapatkan value/data dari tiap EditText dan menyimpannya ke dalam variabel yang telah dibuat
            namaInput = edtName.text.toString()
            genderInput = spinnerGender.selectedItem.toString()
            umurInput = edtUmur.text.toString()
            emailInput = edtEmail.text.toString()
            telpInput = edtTelp.text.toString()
            alamatInput = edtAddress.text.toString()
            when{
                //cek di tiap inputan apakah kosong atau tidak, jika kosong maka tampilkan error
                        namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
                        genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih")
                        umurInput.isEmpty() -> edtUmur.error = "Umur tidak boleh kosong"
                        emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
                        telpInput.isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
                        alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"
                        else -> {
                            //jika semua inputan telah diisi, maka jalankan method goToProfilActivity
                            tampilToast("Profil anda")
                            goToProfilActivity()
                        }
                    }
                }

        //fungsi untuk menampilkan toast
        private fun tampilToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        //fungsi untuk berpindah ke ProfilActivity, sekaligus mengirimkan data hasil input user
        private fun goToProfilActivity() {
            val intent = Intent(this, Profil::class.java)
            val bundle = Bundle()
            bundle.putString("nama", namaInput)
            bundle.putString("gender", genderInput)
            bundle.putString("umur", umurInput)
            bundle.putString("email", emailInput)
            bundle.putString("telp", telpInput)
            bundle.putString("alamat", alamatInput)
            intent.putExtras(bundle)
            startActivity(intent)
        }
}



