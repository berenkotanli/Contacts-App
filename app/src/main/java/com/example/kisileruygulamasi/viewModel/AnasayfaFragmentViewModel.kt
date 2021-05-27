package com.example.kisileruygulamasi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.repository.KisilerDaoRepository

class AnasayfaFragmentViewModel:ViewModel() {
    private val krepo= KisilerDaoRepository()
    var kisilerListesi=MutableLiveData<List<Kisiler>>()

    init{
        kisileriYukle()
        kisilerListesi=krepo.kisileriGetir()
    }

    fun kisileriYukle(){
        krepo.tumKisileriAl()
    }
    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }
    fun sil(kisi_id:Int){
        krepo.kisiSil(kisi_id)
    }
}