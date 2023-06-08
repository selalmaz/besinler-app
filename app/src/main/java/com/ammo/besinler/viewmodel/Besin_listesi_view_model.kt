package com.ammo.besinler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ammo.besinler.model.besin
import com.ammo.besinler.service.BesinAPIService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class Besin_listesi_view_model : ViewModel() {

        val besinler = MutableLiveData<List<besin>>()
        val besin_hata_mesaji = MutableLiveData<Boolean>()
        val besin_yukleniyor = MutableLiveData<Boolean>()

    private val besinApiServis = BesinAPIService()
    private val disposable = CompositeDisposable()
    // disposable kullan at demek
    // rxjava ile gelir
    // aslında bizim burda yapacagımz her bir istek bir disposable olacak
    // çünkü aynı frragment icinde cok fazla istek yapacagiz uygulamalr olablir
    // bu isteklerin sürekli acık kalması hafıza yonetimi icin kötü o yuzden kullanılır



fun refresh_data(){

    verileri_netten_al()

}


    private fun verileri_netten_al(){

        besin_yukleniyor.value=true

        //IO ,Default ,UI thread çeşitleri

        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<besin>>(){

                    override fun onSuccess(t: List<besin>) {
                     //başarılı olursa

                        besinler.value = t
                        besin_hata_mesaji.value=false
                        besin_yukleniyor.value=false
                    }

                    override fun onError(e: Throwable) {
            //hata olursa

                        besin_hata_mesaji.value=true
                        besin_yukleniyor.value=false
                        e.printStackTrace()  // hatayı logcatde gösterir

                    }


                })
        )

    }

}