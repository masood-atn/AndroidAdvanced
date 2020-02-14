package com.android.androidadvance.prayerTimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.androidadvance.R
import kotlinx.android.synthetic.main.activity_prayer_times.*

class PrayerTimesActivity : AppCompatActivity(), PrayerTimesContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer_times)

        val presenter = PrayerTimesPresenter(this)

        btnPrayerTimes.setOnClickListener {
            presenter.onPrayerTimesButtonClicked()
        }
    }

    override fun getCity(): String = edtCity.text.toString()
    override fun setPrayerTimesText(list: HashMap<String, String>) {
        txtPrayerTimes.text = "اذان صبح " + list.get("Fajr") + "\n" +
                "اذان ظهر " + list.get("Dhuhr") + "\n" +
                "اذان مغرب " + list.get("Maghrib")
    }
}
