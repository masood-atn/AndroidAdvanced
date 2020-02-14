package com.android.androidadvance.prayerTimes.Model

import com.android.androidadvance.prayerTimes.PrayerTimesContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PrayerTimesModel(val presenter: PrayerTimesContract.Presenter) {

    fun getPrayerTimes(city: String) {

        var result = ""
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val timingInterface = retrofit.create(RetrofitInterface::class.java)


        timingInterface.getTimings(city, "Iran", 8)
            .enqueue(object : Callback<AladhanResponseModel> {

                override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {
                    presenter.onGetDataFailure(t.message.toString())
                }

                override fun onResponse(
                    call: Call<AladhanResponseModel>,
                    response: Response<AladhanResponseModel>
                ) {
                    presenter.onGetDataSuccess(response)
                }

            })

    }
}