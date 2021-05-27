package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasi.entity.CRUDCevap
import com.example.kisileruygulamasi.retrofit.ApiUtils
import com.example.kisileruygulamasi.retrofit.KisilerDaoInterface
import com.example.kisileruygulamasi.viewModel.KisiKayitFragmentViewModel
import kotlinx.android.synthetic.main.fragment_kisi_detay.view.*
import kotlinx.android.synthetic.main.fragment_kisi_kayit.view.*
import kotlinx.android.synthetic.main.fragment_kisi_kayit.view.editTextKisiAd
import kotlinx.android.synthetic.main.fragment_kisi_kayit.view.editTextKisiTel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisiKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)
        tasarim.kisiKayitFragment=this
        tasarim.kisiKayitToolbarBaslik="Kişi Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun buttonKaydetTikla(kisi_ad:String,kisi_tel:String){
        viewModel.kayit(kisi_ad,kisi_tel)
    }
}