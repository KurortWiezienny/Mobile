package com.example.prison

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import models.CellItem


class HomeAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_acitivity)

        val cellItem = generateDummyList(100)

        val recycler = findViewById<RecyclerView>(R.id.recycler_view)

        recycler.adapter = CellAdapter(cellItem)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)


        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottom_nav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(applicationContext, HomeAcitivity::class.java)
                    startActivity(intent)
                }
                R.id.logs -> {
                    val intent = Intent(applicationContext, LogsActivity::class.java)
                    startActivity(intent)
                }
                R.id.profile -> {
                    val intent = Intent(applicationContext, ProfileActivity::class.java)
                    startActivity(intent)
                }

            }
            false
        })

    }

    private fun generateDummyList(size: Int) : List<CellItem>
    {
        val list = ArrayList<CellItem>()

        for (i in 0 until size)
        {
            if (i%2 == 0)
            {
                list.add(CellItem("number " + (i + 1), "John"))
            }
            else
            {
                list.add(CellItem("number " + (i + 1), "George"))
            }

        }

        return list
    }
}