package com.ammo.besinler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ammo.besinler.databinding.FragmentBesinDetayiBinding
import com.ammo.besinler.viewmodel.Besin_detayi_view_model
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayiFragment : Fragment() {

    private var _binding: FragmentBesinDetayiBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: Besin_detayi_view_model

    private var besinId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBesinDetayiBinding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this)[Besin_detayi_view_model::class.java]
            viewModel.room_verisini_al()


        arguments?.let {

            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }

        obser_live_data()



    }


    fun obser_live_data(){

        viewModel.besin_live_data.observe(viewLifecycleOwner, Observer { besin->

            besin?.let {
                besin_ismi.text = it.besin_isim
                besin_kalorisi.text= it.besin_kalori
                besin_karbonhidrat.text=it.besin_karbonhidrat
                besin_proteini.text=it.besin_protein
                besin_yag.text=it.besin_yag
            }

        })

    }

}