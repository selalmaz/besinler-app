package com.ammo.besinler.service

import com.ammo.besinler.model.besin
import com.google.gson.Gson
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BesinAPIService {


    // https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    // BASE URL -> https://raw.githubusercontent.com/
    // atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())  // json formatını modele ceviriyoruz
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // rxjava kullancagımızı belırtiyorz rxjava kullanmasak yapmaya gerek yoktu
        .build()
        .create(BesinAPI::class.java)

        fun getData() : Single<List<besin>>
        {
            return api.getBesin()
        }





}