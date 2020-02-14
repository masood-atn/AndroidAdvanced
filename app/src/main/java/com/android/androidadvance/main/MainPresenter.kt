package com.android.androidadvance.main

import java.text.SimpleDateFormat
import java.util.*


class MainPresenter(val view: MainActivity) : MainContract.Presenter {

    val model = MainModel(this)

    override fun setDrawerHeaderImage() {
        val currentTime = SimpleDateFormat("HH", Locale.getDefault()).format(Date())
        var result = "default"
        when (currentTime.toInt()) {
            in 1..5 -> result = "night"
            in 6..11 -> result = "morning"
            in 12..17 -> result = "afternoon"
            in 18..21 -> result = "evening"
            in 22..24 -> result = "night"
            else -> result = "default"
        }
        view.setImage(result)
    }

    override fun onItemClicked(item: String) {
        if (item == "Prayer Times") {
            view.navigateToPrayerTimes()
        }

    }

}