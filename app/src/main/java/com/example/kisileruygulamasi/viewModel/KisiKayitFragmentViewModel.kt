package com.example.kisileruygulamasi.viewModel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.repository.KisilerDaoRepository

class KisiKayitFragmentViewModel: ViewModel() {
    private val krepo=KisilerDaoRepository()

        fun kayit(kisi_ad:String,kisi_tel:String){
            krepo.kisiKayit(kisi_ad,kisi_tel)
        }

}