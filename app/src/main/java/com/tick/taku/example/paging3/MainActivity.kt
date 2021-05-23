package com.tick.taku.example.paging3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.tick.taku.example.paging3.core.provideViewModels
import com.tick.taku.example.paging3.data.repository.internal.CatRepositoryImpl
import com.tick.taku.example.paging3.databinding.ActivityMainBinding
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.gateway.ApiClient
import com.tick.taku.example.paging3.ui.viewmodel.CatViewModel
import com.tick.taku.example.paging3.ui.widget.CatPagingAdapter
import com.tick.taku.example.paging3.usecase.internal.CatUseCaseImpl

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val viewModel: CatViewModel by provideViewModels {
        CatViewModel(CatUseCaseImpl(CatRepositoryImpl(ApiClient())))
    }

    private val listAdapter = CatPagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.catList.adapter = listAdapter

        viewModel.cats.observe(this) {
            listAdapter.submitWhenStarted(it)
        }
    }

    private fun CatPagingAdapter.submitWhenStarted(data: PagingData<Cat>) =
        lifecycleScope.launchWhenStarted { submitData(data) }
}