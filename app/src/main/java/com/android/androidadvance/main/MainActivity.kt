package com.android.androidadvance.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.androidadvance.R
import com.android.androidadvance.prayerTimes.PrayerTimesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    val list = arrayListOf("Prayer Times")
    val presenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter.setDrawerHeaderImage()


        val btnDrawer = btnDrawer

        var clickListener: (String) -> Unit = {
            onClick(it)
        }

        recyclerViewList.layoutManager = LinearLayoutManager(this)

        recyclerViewList.adapter = ListAdapter(list, clickListener)

        btnDrawer.setOnClickListener(View.OnClickListener {
            val drawerLayout = drawer_layout
            drawerLayout.openDrawer(GravityCompat.START)
        })

    }

    override fun onClick(name: String) {
        presenter.onItemClicked(name)
    }

    override fun setImage(result: String) {
        when (result) {
            "morning" -> imgDrawerHeader.setImageResource(R.drawable.morning)
            "afternoon" -> imgDrawerHeader.setImageResource(R.drawable.afternoon)
            "evening" -> imgDrawerHeader.setImageResource(R.drawable.evening)
            "night" -> imgDrawerHeader.setImageResource(R.drawable.night)
            else -> imgDrawerHeader.setImageResource(R.drawable.afternoon)
        }
    }

    override fun navigateToPrayerTimes() {
        startActivity(Intent(this, PrayerTimesActivity::class.java))
    }
}

