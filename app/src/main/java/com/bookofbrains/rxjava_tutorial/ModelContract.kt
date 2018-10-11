package com.bookofbrains.rxjava_tutorial

import io.reactivex.Single

interface ModelContract {
    fun getCountriesFromHttp(): Single<List<Map<String, String>>>
}