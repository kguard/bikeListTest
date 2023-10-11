package com.kguard.bikelisttest.ui.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.kguard.bikelisttest.R
import com.kguard.bikelisttest.adapter.BikeListAdapter
import com.kguard.bikelisttest.base.BaseFragment
import com.kguard.bikelisttest.databinding.FragmentMainBinding
import com.kguard.bikelisttest.util.FetchState
import com.kguard.bikelisttest.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val viewModel : MainViewModel by viewModels()
    private val bikeListAdapter = BikeListAdapter()
    private val bikeListFlowAdapter = BikeListAdapter()
    override fun initData() {
       // viewModel.getBikeList(1,5)
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
        viewModel.fetchState.observe(this)
        {
            when(it.second){
                FetchState.FAIL-> {
                    Toast.makeText(this.context, "연결실패", Toast.LENGTH_SHORT).show()
                }
                else ->{
                    Toast.makeText(this.context, "흠..", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun initListener() {

    }

}