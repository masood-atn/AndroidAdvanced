package com.android.androidadvance.prayerTimes

import android.util.Log
import com.android.androidadvance.prayerTimes.Model.AladhanResponseModel
import com.android.androidadvance.prayerTimes.Model.PrayerTimesModel
import retrofit2.Response

class PrayerTimesPresenter(val view: PrayerTimesContract.View) : PrayerTimesContract.Presenter {

    val model = PrayerTimesModel(this)
    override fun onGetDataFailure(throwable: String) {
        Log.d("TAG", throwable)
    }

    override fun onGetDataSuccess(response: Response<AladhanResponseModel>) {

        val list: HashMap<String, String> = HashMap()
        list.put("Fajr", response.body()?.data?.timings?.Fajr.toString())
        list.put("Dhuhr", response.body()?.data?.timings?.Dhuhr.toString())
        list.put("Maghrib", response.body()?.data?.timings?.Maghrib.toString())

        view.setPrayerTimesText(list)

    }

    override fun onPrayerTimesButtonClicked() {
        //val city = view.getCity()
        model.getPrayerTimes(view.getCity())
    }
}