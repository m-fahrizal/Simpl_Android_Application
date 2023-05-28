package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvbike: RecyclerView
    private val list = ArrayList<Bike>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvbike = findViewById(R.id.rv_bike)
        rvbike.setHasFixedSize(true)

        list.addAll(getListBike())
        showRecyclerList()
    }

    private fun getListBike(): ArrayList<Bike> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataOldPrice = resources.getStringArray(R.array.data_oldPrice)
        val dataNewPrice = resources.getStringArray(R.array.data_newPrice)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listBike = ArrayList<Bike>()
        for (i in dataName.indices) {
            val bike = Bike(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataOldPrice[i], dataNewPrice[i])
            listBike.add(bike)
        }
        return listBike
    }

    private fun showRecyclerList() {
        rvbike.layoutManager = LinearLayoutManager(this)
        val listBikeAdapter = ListBikeAdapter(list)
        rvbike.adapter = listBikeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}