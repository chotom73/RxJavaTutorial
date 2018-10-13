package com.bookofbrains.rxjava_tutorial

import android.annotation.SuppressLint
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bookofbrains.rxjava_tutorial.retrofit.CountriesPresenter
import com.bookofbrains.rxjava_tutorial.retrofit.Country
import com.bookofbrains.rxjava_tutorial.retrofit.PresenterContract
import com.bookofbrains.rxjava_tutorial.retrofit.ViewContract
import com.bookofbrains.rxjava_tutorial.room.UserDatabase
import com.bookofbrains.rxjava_tutorial.room.UserEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewContract {

    val TAG: String = "MainActivity"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myPresenter: PresenterContract = CountriesPresenter(this)
        myPresenter.getCountries()

        val database = Room.databaseBuilder(applicationContext,
                UserDatabase::class.java!!, "database-name")
                .allowMainThreadQueries()
                .build()

        val user1 = UserEntity(1, "name1", "email1")
        val user2 = UserEntity(2, "name2", "email2")
        val user3 = UserEntity(3, "name3", "email3")


        database.userDao().deleteAll()

        database.userDao().addUserToDatabase(user1)
        database.userDao().addUserToDatabase(user2)
        database.userDao().addUserToDatabase(user3)

        val userObservable: Single<List<UserEntity>> = database.userDao().getAllUser()

        userObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe (
                    { data ->
                        Log.d(TAG, data.size.toString())
                    },
                    { err ->
                        Log.e(TAG, "{$err.message}")
                    }
                )
    }

    override fun fillCountriesSpinner(countries: List<Country>) {
        val countyNames = countries.map {
            it.countryName
        }
        val adapter = ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                countyNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countriesSpinnerId.adapter = adapter
    }

    override fun errorMessage(msg: String) {
        Toast.makeText(this, "error : " + msg, Toast.LENGTH_SHORT)
    }

}


