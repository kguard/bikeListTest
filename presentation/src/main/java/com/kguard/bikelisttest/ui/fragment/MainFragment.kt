package com.kguard.bikelisttest.ui.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kguard.bikelisttest.R
import com.kguard.bikelisttest.adapter.BikeListAdapter
import com.kguard.bikelisttest.base.BaseFragment
import com.kguard.bikelisttest.databinding.FragmentMainBinding
import com.kguard.bikelisttest.util.FetchState
import com.kguard.bikelisttest.viewModel.MainViewModel
import com.kguard.domain.state.ResultState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.TimeoutException

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val viewModel : MainViewModel by viewModels()
    private val bikeListAdapter1 = BikeListAdapter()
    private val bikeListAdapter2 = BikeListAdapter()
    override fun initData() {
//        viewModel.getBikeList(1,5) //1
//        viewModel.getBikeListFlow(5,10) //2
//        viewModel.getBikeListStateFlow(1,5) //3
        viewModel.getBikeListWithResponseState(1,5) //4
    }

    override fun initUI() {
        //TODO("Not yet implemented")
        binding.apply {
            rv1.adapter = bikeListAdapter1
            rv2.adapter = bikeListAdapter2
        }
    }

    override fun initObserver() {
//        viewModel.bikeListLiveData.observe(viewLifecycleOwner){//1
//            binding.tvRv1.text = "liveData"
//            bikeListAdapter1.setData(it)
//        }
//        viewModel.bikeListFlow.observe(viewLifecycleOwner){//2
//            binding.tvRv2.text = "flow"
//            bikeListAdapter2.setData(it)
//        }
//        lifecycleScope.launch { //3
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//                viewModel.bikeListStateFlow.collect{
//                    binding.tvRv1.text = "stateFlow"
//                    bikeListAdapter1.setData(it)
//                }
//            }
//        }
        lifecycleScope.launch { //3
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.bikeListStateFlowWithResponse.collect{
                    binding.tvRv1.text = "stateFlowWithResponse"
                    when(it)
                    {
                        is ResultState.Success ->{
                            binding.progressBar.visibility= View.GONE
                            bikeListAdapter1.setData(it.data)
                        }
                        is ResultState.Fail.Error -> {
                            binding.progressBar.visibility= View.GONE
                            binding.tvError1.apply {
                                this.visibility = View.VISIBLE
                                text = (it.code+"\n"+it.message)
                            }
                        }
                        is ResultState.Fail.Exception -> {
                            binding.progressBar.visibility= View.GONE
                            binding.tvError1.apply {
                                this.visibility = View.VISIBLE
                                text = (it.e.toString()+"\n"+it.message)
                            }
                        }
                        is ResultState.Loading ->{
                            binding.progressBar.visibility= View.VISIBLE
                        }

                    }
                }
            }
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