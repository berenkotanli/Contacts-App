package com.example.kisileruygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.entity.CRUDCevap
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.entity.KisilerCevap
import com.example.kisileruygulamasi.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.retrofit.KisilerDaoInterface
import com.example.kisileruygulamasi.viewModel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.card_tasarim.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerAdapter(var mContext:Context,
                     var kisilerListesi:List<Kisiler>,
                     var viewModel:AnasayfaFragmentViewModel)

    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding)
        :RecyclerView.ViewHolder(cardTasarimBinding.root){
        var cardTasarimBinding:CardTasarimBinding

        init {
          this.cardTasarimBinding=cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)

        val t = holder.cardTasarimBinding
        t.kisiNesnesi = kisi

        t.satirCard.setOnClickListener {

            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)

            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id)
                    Snackbar.make(it,"Silindi",Snackbar.LENGTH_SHORT).show()
                }.show()

        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

}