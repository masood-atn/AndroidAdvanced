package com.android.androidadvance.main

interface MainContract {


    interface View {
        fun onClick(name: String)
        fun setImage(result: String)
        fun navigateToPrayerTimes()

    }

    interface Presenter {

        fun setDrawerHeaderImage()
        fun onItemClicked(item: String)


    }

}

