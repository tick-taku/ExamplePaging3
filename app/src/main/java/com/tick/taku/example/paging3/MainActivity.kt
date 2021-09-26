package com.tick.taku.example.paging3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.tick.taku.example.paging3.core.andRefreshable
import com.tick.taku.example.paging3.databinding.ActivityMainBinding
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.ui.viewmodel.CatViewModel
import com.tick.taku.example.paging3.ui.widget.CatPagingAdapter
import com.tick.taku.example.paging3.ui.widget.CatPagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val viewModel: CatViewModel by viewModels()

    private val listAdapter = CatPagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.catList.adapter = listAdapter
            .andRefreshable(binding.refreshLayout)
            .withLoadStateFooter(CatPagingLoadStateAdapter { listAdapter.retry() })

        viewModel.cats.observe(this) {
            listAdapter.submitWhenStarted(it)
        }
    }

    private fun CatPagingAdapter.submitWhenStarted(data: PagingData<Cat>) =
        lifecycleScope.launchWhenStarted { submitData(data) }
}