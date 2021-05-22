package com.tick.taku.example.paging3.ui.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagingData
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase

class CatViewModel(private val useCase: CatUseCase): ViewModel() {

    val cats: LiveData<PagingData<Cat>> = useCase.cats(0).asLiveData()

}