package com.bookofbrains.rxjava_tutorial.retrofit

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesService {
    @GET("/v1/countries")
    fun getCountriesServer(): Single<List<Country>>
}