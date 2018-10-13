package com.bookofbrains.rxjava_tutorial.retrofit

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesModel: ModelContract {

    private val BASE_URL = "http://api.drivewealth.io/"

    private var retrofit: Retrofit? = null

    override fun getCountriesFromHttp(): Single<List<Country>> {
        return createRetrofit().create(CountriesService::class.java).getCountriesServer()
    }


    fun createRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        }
        return retrofit!!
    }
}