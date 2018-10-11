package com.bookofbrains.rxjava_tutorial

import retrofit2.Retrofit

class CountriesServiceManger {

    fun getCountriesServer(retrofit: Retrofit): CountriesService {
        return retrofit.create(CountriesService::class.java)
    }

    // http://country.io/names.json
}