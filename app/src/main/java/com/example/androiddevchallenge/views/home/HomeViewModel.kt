package com.example.androiddevchallenge.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.CardModel

class HomeViewModel : ViewModel() {
    private val _search = MutableLiveData("")
    val search: LiveData<String> = _search

    val itemsFavorite = arrayListOf<CardModel>(
        CardModel(R.drawable.short_mantras,"Short mantras"),
        CardModel(R.drawable.agung_pandit_wiguna,"Nature meditations"),
        CardModel(R.drawable.chevanon_photography,"Stress and anxiety"),
        CardModel(R.drawable.cliff_booth,"Self massage"),
        CardModel(R.drawable.cottonbro,"Overwhelmed"),
        CardModel(R.drawable.elly_fairytale,"Nightly wind down")
    )
    val itemsBody = arrayListOf<CardModel>(
        CardModel(R.drawable.freestocksorg,"Inversions"),
        CardModel(R.drawable.jakub_novacek,"Quick yoga"),
        CardModel(R.drawable.jim,"Stretching"),
        CardModel(R.drawable.karolina_grabowska,"Tabata"),
        CardModel(R.drawable.nathan_cowley,"HIIT"),
        CardModel(R.drawable.nothing_ahead,"Pre-natal yoga")
    )
    val itemsMind = arrayListOf<CardModel>(
        CardModel(R.drawable.ruvim,"Meditate"),
        CardModel(R.drawable.scott_webb,"With kids"),
        CardModel(R.drawable.short_mantras,"Aromatherapy"),
        CardModel(R.drawable.suraphat_nueaon,"On the go"),
        CardModel(R.drawable.the_lazy_artist_gallery,"With pets"),
        CardModel(R.drawable.valeria_ushakova,"High stress")
    )

    fun onSearchChanged(newTxt: String) {
        _search.value = newTxt
    }
}