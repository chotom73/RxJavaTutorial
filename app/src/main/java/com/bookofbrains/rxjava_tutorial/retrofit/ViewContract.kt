package com.bookofbrains.rxjava_tutorial.retrofit

interface ViewContract {
    fun fillCountriesSpinner(countries: List<Country>)

    fun errorMessage(msg: String)
}