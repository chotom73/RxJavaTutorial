package com.bookofbrains.rxjava_tutorial

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins.onSubscribe
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

import java.lang.Exception
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), ViewContract {


    //var myPresenter: PresenterContract? = null

    val TAG: String = "MainActivity"

    private var disposable: CompositeDisposable? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myPresenter: PresenterContract = CountriesPresenter(this)
        myPresenter.getCountries()

    }

    override fun fillCountriesSpinner(countries: List<Map<String, String>>) {
        val adapter: ArrayAdapter<Map<String, String>> = ArrayAdapter<Map<String, String>>(this,
                R.layout.support_simple_spinner_dropdown_item,
                countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countriesSpinnerId.adapter = adapter
    }

    override fun errorMessage(msg: String) {
        Toast.makeText(this, "error : " + msg, Toast.LENGTH_SHORT)
    }

}


