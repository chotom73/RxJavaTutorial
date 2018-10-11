package com.bookofbrains.rxjava_tutorial

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import io.reactivex.functions.BiConsumer
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CountriesPresenter: PresenterContract {

    var view: ViewContract? = null;
    var model: ModelContract? = null;

    constructor(context: Context) {
        view = context as ViewContract
        model = CountriesModel()
    }

    override fun getCountries() {
        model!!.getCountriesFromHttp()
                .subscribeOn(Schedulers.computation())
                .subscribe (
                    { countries ->
                        Log.d("CountriesPresenter", "11111111111")
                        view?.fillCountriesSpinner(countries)
                    },
                    { err ->
                        Log.e("CountriesPresenter", "{$err.message}")
                        view?.errorMessage(err.message!!)
                    }
                )
    }
}