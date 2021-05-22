package com.tick.taku.example.paging3.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase

class CatViewModel(private val useCase: CatUseCase): ViewModel() {

    private val _cats: MutableLiveData<List<Cat>> = MutableLiveData()
    val cats: LiveData<List<Cat>> = _cats

}