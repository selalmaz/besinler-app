package com.ammo.besinler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ammo.besinler.R
import com.ammo.besinler.gorsel_indir
import com.ammo.besinler.model.besin
import com.ammo.besinler.place_holder_yap
import com.ammo.besinler.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.recyler_view.view.*

class besin_recycler_adapter(val besinListesi : ArrayList<besin>):RecyclerView.Adapter<besin_recycler_adapter.Besin_view_holder>() {

    class Besin_view_holder(itemView: View): RecyclerView.ViewHolder(itemView){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Besin_view_holder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyler_view,parent,false)
        return Besin_view_holder(view)



    }

    override fun onBindViewHolder(holder: Besin_view_holder, position: Int) {

        holder.itemView.isim.text = besinListesi.get(position).besin_isim
        holder.itemView.kalori.text = besinListesi.get(position).besin_kalori

        holder.itemView.setOnClickListener {

            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(0)
            Navigation.findNavController(it).navigate(action)






        }

        holder.itemView.imageView.gorsel_indir(besinListesi.get(position).besin_gorsel,
            place_holder_yap(holder.itemView.context))

    }

    override fun getItemCount(): Int {

        return besinListesi.size
    }

    fun besin_listesini_guncelle(yeni_besin_listesi: List <besin>){
        besinListesi.clear()
        besinListesi.addAll(yeni_besin_listesi)
        notifyDataSetChanged()


    }





}