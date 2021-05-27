package com.example.kisileruygulamasi.viewModel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.repository.KisilerDaoRepository

class KisiDetayFragmentViewModel: ViewModel() {
    private val krepo= KisilerDaoRepository()
    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        krepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
}}