package com.tick.taku.example.paging3.ui.viewmodel

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val useCase: CatUseCase
): ViewModel() {

    val cats: LiveData<PagingData<Cat>> =
        Pager(PagingConfig(pageSize = useCase.limit, initialLoadSize = useCase.limit)) {
            useCase.cats()
        }.flow.asLiveData()

}