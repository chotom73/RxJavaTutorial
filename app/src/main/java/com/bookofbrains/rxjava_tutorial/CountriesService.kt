package com.bookofbrains.rxjava_tutorial

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesService {
    @GET("/names.json")
    fun getCountriesServer(): Single<List<Map<String, String>>>
}