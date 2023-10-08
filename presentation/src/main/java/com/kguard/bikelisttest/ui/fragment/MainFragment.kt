package com.kguard.bikelisttest.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.kguard.bikelisttest.R
import com.kguard.bikelisttest.adapter.BikeListAdapter
import com.kguard.bikelisttest.base.BaseFragment
import com.kguard.bikelisttest.databinding.FragmentMainBinding
import com.kguard.bikelisttest.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val viewModel : MainViewModel by viewModels()
    private val bikeListAdapter = BikeListAdapter()
    override fun initData() {
        viewModel.getBikeList(1,5)
    }

    override fun initUI() {
        //TODO("Not yet implemented")
        binding.apply {
            rvLiveData.adapter = bikeListAdapter
        }
    }

    override fun initObserver() {
        viewModel.bikeList.observe(viewLifecycleOwner){
            bikeListAdapter.setData(it)
        }
    }

    override fun initListener() {

    }

}