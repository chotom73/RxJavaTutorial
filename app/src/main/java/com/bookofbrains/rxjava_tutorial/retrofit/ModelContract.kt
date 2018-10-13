package com.bookofbrains.rxjava_tutorial.retrofit

import io.reactivex.Single

interface ModelContract {
    fun getCountriesFromHttp(): Single<List<Country>>
}