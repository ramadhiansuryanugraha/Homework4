package com.example.unj.cs.hw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailCoffeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_coffee)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val coffee = intent.getParcelableExtra<Coffee>(MainActivity.INTENT_PARCELABLE)

        val imgCoffee = findViewById<ImageView>(R.id.img_item_photo)
        val nameCoffee = findViewById<TextView>(R.id.tv_item_name)
        val descCoffee = findViewById<TextView>(R.id.tv_item_description)

        imgCoffee.setImageResource(coffee?.imgCoffee!!)
        nameCoffee.text = coffee.nameCoffee
        descCoffee.text = coffee.descCoffee
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}