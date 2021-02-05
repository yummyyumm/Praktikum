package com.example.praktikum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HitungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        val buttonHitung = findViewById<Button>(R.id.buttonHitung)
        val editPanjang = findViewById<EditText>(R.id.editPanjang)
        val editLebar = findViewById<EditText>(R.id.editLebar)
        val editTinggi = findViewById<EditText>(R.id.editTinggi)
        val textHasil = findViewById<TextView>(R.id.textHasil)


        buttonHitung.setOnClickListener{
            var isEmptyField = false

            val stringPanjang =editPanjang.text.toString().trim()
            val stringLebar =editLebar.text.toString().trim()
            val stringTinggi =editTinggi.text.toString().trim()

            if (stringPanjang.equals("")){
                isEmptyField = true
                editPanjang.error = "Data kosong"
            }
            if (stringLebar.isEmpty()){
                isEmptyField = true
                editLebar.error = "Data kosong"

            }
            if (stringTinggi == ""){
                isEmptyField = true
                editTinggi.error = "Data kosong"

            }
            if (!isEmptyField){

                val panjang = stringPanjang.toFloat()
                val lebar = stringLebar.toFloat()
                val tinggi = stringTinggi.toFloat()

                textHasil.text = (panjang * lebar * tinggi).toString()

            }




        }
    }
}