package com.ammo.besinler

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.gorsel_indir(url:String?,placeholder:CircularProgressDrawable){

    val options = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)


    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)



}

fun place_holder_yap(context: Context):CircularProgressDrawable{

    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        // yukardakı kod donen dairein kalınlıgı
        centerRadius = 40f  // yarıcapi

        start()
    }


}