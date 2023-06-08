package com.ammo.besinler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ammo.besinler.adapter.besin_recycler_adapter
import com.ammo.besinler.databinding.FragmentBesinListesiBinding
import com.ammo.besinler.viewmodel.Besin_listesi_view_model
import kotlinx.android.synthetic.main.fragment_besin_detayi.*
import kotlinx.android.synthetic.main.fragment_besin_listesi.*


class BesinListesiFragment : Fragment() {


    private var _binding: FragmentBesinListesiBinding?= null
    private val binding get () = _binding!!
    private lateinit var viewModel:Besin_listesi_view_model
    private val recylerBesinAdapter =  besin_recycler_adapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBesinListesiBinding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[Besin_listesi_view_model::class.java]
        // view model init yaptık
        viewModel.refresh_data()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = recylerBesinAdapter


        binding.swipeRefreshLayout.setOnRefreshListener {


            binding.besinHataMesaji.visibility=View.GONE
            binding.recyclerView.visibility=View.GONE
            binding.besinProgressBar.visibility=View.VISIBLE
            viewModel.refresh_data()
            binding.swipeRefreshLayout.isRefreshing=false

        }


        observe_live_data()



    }

    fun observe_live_data(){

        viewModel.besinler.observe(viewLifecycleOwner, Observer { besinler->
            besinler?.let{

                binding.recyclerView.visibility=View.VISIBLE
                recylerBesinAdapter.besin_listesini_guncelle(besinler)

            }
        })
        // ilk paranteze this veya viewlifecyleowner verince oluyor
        viewModel.besin_hata_mesaji.observe(viewLifecycleOwner, Observer { hata->

            hata?.let {
                if(it){
                    binding.besinHataMesaji.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }

                else
                    binding.besinHataMesaji.visibility =View.GONE
            }
        })

        viewModel.besin_yukleniyor.observe(viewLifecycleOwner, Observer { yukleniyor->

            yukleniyor?.let {

                if(it){

                    binding.recyclerView.visibility = View.GONE
                    binding.besinHataMesaji.visibility = View.GONE
                    binding.besinProgressBar.visibility = View.VISIBLE
                }
                else{

                   binding.besinProgressBar.visibility = View.GONE

                }
            }

        })



    }



    override fun onDestroyView() {
        super.onDestroyView()
    }


}