package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class BikeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_detail)

        val superbike = intent.getParcelableExtra("key_bike") as Bike?

        val name = findViewById<TextView>(R.id.tv_item_name)
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val description = findViewById<TextView>(R.id.tv_item_description)
        val oldPrice = findViewById<TextView>(R.id.tv_item_oldPrice)
        val newPrice = findViewById<TextView>(R.id.tv_item_newPrice)

        name.text = superbike?.name!!
        photo.setImageResource(superbike?.photo!!)
        description.text = superbike.description
        oldPrice.text = superbike.oldPrice
        newPrice.text = superbike.newPrice
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(this@BikeDetail, "Nothing to Share", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}