package com.kguard.bikelisttest.ui.fragment

import androidx.fragment.app.viewModels
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
    private val bikeListFlowAdapter = BikeListAdapter()
    override fun initData() {
        viewModel.getBikeList(1,5)
        viewModel.getBikeListFlow(5,10)
    }

    override fun initUI() {
        //TODO("Not yet implemented")
        binding.apply {
            rvLiveData.adapter = bikeListAdapter
            rvStateFlow.adapter = bikeListFlowAdapter
        }
    }

    override fun initObserver() {
        viewModel.bikeListLiveData.observe(viewLifecycleOwner){
            bikeListAdapter.setData(it)
        }
        viewModel.bikeListFlow.observe(viewLifecycleOwner){
            bikeListFlowAdapter.setData(it)
        }
    }

    override fun initListener() {

    }

}