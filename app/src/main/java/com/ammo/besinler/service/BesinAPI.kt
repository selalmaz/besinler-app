package com.ammo.besinler.service

import com.ammo.besinler.model.besin
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {

    // istekler (GET ve POST)
    // genelde sunucuya veri yollucaksak POST kullanırızı
    // sunucudan veri alıcaksak bu get olur


    // retrofit le yapıyoruz

    // https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    // BASE URL -> https://raw.githubusercontent.com/
       // atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json


    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin() : Single<List<besin>>     // boylede yapılabilir fun getBesin() : Call<List<Besin>>




}