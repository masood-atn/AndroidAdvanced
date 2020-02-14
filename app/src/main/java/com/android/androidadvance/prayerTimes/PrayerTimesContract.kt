package com.android.androidadvance.prayerTimes

import com.android.androidadvance.prayerTimes.Model.AladhanResponseModel
import retrofit2.Response

interface PrayerTimesContract {


    interface View {
        fun getCity(): String
        fun setPrayerTimesText(list: HashMap<String, String>)

    }

    interface Presenter {

        fun onGetDataFailure(throwable: String)
        fun onGetDataSuccess(response: Response<AladhanResponseModel>)
        fun onPrayerTimesButtonClicked()

    }

}

