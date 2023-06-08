package com.ammo.besinler.model

import com.google.gson.annotations.SerializedName

data class besin(

    @SerializedName("isim")  //degisken isimleriyle verimizdeki isimler farklı o yuzden bunu belirttik aynı olsaydı belirtmeye gerek yoktu
    val besin_isim: String?,
    @SerializedName("kalori")
    val besin_kalori: String?,
    @SerializedName("karbonhidrat")
    val besin_karbonhidrat: String?,
    @SerializedName("protein")
    val besin_protein: String?,
    @SerializedName("yag")
    val besin_yag: String?,
    @SerializedName("gorsel")
    val besin_gorsel: String?
                 ){

    // bu class bizim modelimiz
}
