package com.bookofbrains.rxjava_tutorial.retrofit

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountriesPresenter: PresenterContract {

    var view: ViewContract? = null
    var model: ModelContract? = null

    constructor(context: Context) {
        view = context as ViewContract
        model = CountriesModel()
    }

    @SuppressLint("CheckResult")
    override fun getCountries() {
        model!!.getCountriesFromHttp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                    { data ->
                        Log.d("CountriesPresenter", data.size.toString())
                        view?.fillCountriesSpinner(data)
                    },
                    { err ->
                        Log.e("CountriesPresenter", "{$err.message}")
                        view?.errorMessage(err.message!!)
                    }
                )
    }
}