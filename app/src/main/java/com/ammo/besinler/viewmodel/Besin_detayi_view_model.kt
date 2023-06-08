package com.ammo.besinler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ammo.besinler.model.besin

class Besin_detayi_view_model:ViewModel() {



    val besin_live_data = MutableLiveData<besin>()




    fun room_verisini_al(){

        val muz= besin("Muz","100","10","5","1","www.test.com")
        besin_live_data.value = muz


    }






}