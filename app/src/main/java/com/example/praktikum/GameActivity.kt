package com.example.praktikum

import android.graphics.Color
import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val BATU = 1
private const val GUNTING = 2
private const val KERTAS = 3


class GameActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "username"
    }

    var username : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        username = intent.getStringExtra(EXTRA_USER).toString()


        val textHasil = findViewById<TextView >(R.id.textHasil)
        val textPlayer  = findViewById<TextView>(R.id.textPlayer)


        val buttonBatu = findViewById<Button>(R.id.buttonBatu)
        val buttonGunting = findViewById<Button>(R.id.buttonGunting)
        val buttonKertas = findViewById<Button>(R.id.buttonKertas)


        var pilihanKomputer:Int
        var pilihanPlayer:Int

        buttonBatu.setOnClickListener{
            pilihanPlayer = BATU
            pilihanKomputer = getPilihanKomputer()
            textHasil.text = suwit(pilihanPlayer, pilihanKomputer)
            textPlayer.text = "BATU"
            showPilihanKomputer(pilihanKomputer)


        }
        buttonGunting.setOnClickListener{
            pilihanPlayer = GUNTING
            pilihanKomputer = getPilihanKomputer()
            textHasil.text = suwit(pilihanPlayer, pilihanKomputer)
            textPlayer.text = "GUNTING"
            showPilihanKomputer(pilihanKomputer)
        }
        buttonKertas.setOnClickListener{
            pilihanPlayer = KERTAS
            pilihanKomputer = getPilihanKomputer()
            textHasil.text = suwit(pilihanPlayer, pilihanKomputer)
            textPlayer.text = "KERTAS"
            showPilihanKomputer(pilihanKomputer)
        }


    }

    private fun showPilihanKomputer(pilihanKomputer: Int) {
        val textKomputer  = findViewById<TextView>(R.id.textKomputer)
        when(pilihanKomputer){
            1 -> textKomputer.text = "Komputer memilih : BATU"
            2 -> textKomputer.text = "Komputer memilih : GUNTING"
            3 -> textKomputer.text = "Komputer memilih : KERTAS"
        }

    }

    fun getPilihanKomputer():Int{
        return Random.nextInt(3) + 1;
    }

    fun suwit(pilihanPlayer: Int, pilihanKomputer: Int):String{
        var hasil: String= ""
        if (pilihanPlayer == pilihanKomputer) {
            hasil = username + " SERI"
        }
        else if((pilihanPlayer == BATU && pilihanKomputer == KERTAS) ||
                (pilihanPlayer == GUNTING && pilihanKomputer == BATU) ||
                (pilihanPlayer == KERTAS && pilihanKomputer == GUNTING)) {
            hasil = username + " YOU LOSE"

        }
        else {
            hasil = username + " YOU WIN"

        }

        return hasil

    }




}