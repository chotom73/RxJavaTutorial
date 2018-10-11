package com.bookofbrains.rxjava_tutorial

interface ViewContract {
    fun fillCountriesSpinner(countries: List<Map<String, String>>)

    fun errorMessage(msg: String)
}