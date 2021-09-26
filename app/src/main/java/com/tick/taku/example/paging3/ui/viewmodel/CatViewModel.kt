package com.tick.taku.example.paging3.ui.viewmodel

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase

class CatViewModel(private val useCase: CatUseCase): ViewModel() {

    val cats: LiveData<PagingData<Cat>> =
        Pager(PagingConfig(pageSize = useCase.limit, initialLoadSize = useCase.limit)) {
            useCase.cats()
        }.flow.asLiveData()

}