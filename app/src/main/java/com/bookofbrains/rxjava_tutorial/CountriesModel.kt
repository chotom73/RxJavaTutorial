package com.bookofbrains.rxjava_tutorial

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountriesModel: ModelContract {
    override fun getCountriesFromHttp(): Single<List<Map<String, String>>> {
        return CountriesServiceManger()
                .getCountriesServer(createRetrofit())
                .getCountriesServer()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl("http://country.io")
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    private fun createGson(): Gson {
        return GsonBuilder().create()
    }
}