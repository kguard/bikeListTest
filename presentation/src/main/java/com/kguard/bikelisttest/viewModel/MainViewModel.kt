package com.kguard.bikelisttest.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.kguard.bikelisttest.base.BaseViewModel
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.state.ResultState
import com.kguard.domain.usecase.BikeListFlowUseCase
import com.kguard.domain.usecase.BikeListLiveDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bikeListLiveDataUseCase: BikeListLiveDataUseCase,
    private val bikeListFlowUseCase: BikeListFlowUseCase
) :
    BaseViewModel() {
    private val _bikeListLiveData: MutableLiveData<List<DomainBikeList>> = MutableLiveData()
    val bikeListLiveData: LiveData<List<DomainBikeList>>
        get() = _bikeListLiveData

    // viewModel에서 flow를 사용하지 않는 이유: flow는 생명주기를 모르기 때문에 viewModel에서 데이터를 받아와야한다고 생각
    private val _bikeListFlow: MutableLiveData<List<DomainBikeList>> = MutableLiveData()
    val bikeListFlow: LiveData<List<DomainBikeList>>
        get() = _bikeListFlow


//    private val _bikeListStateFlow = MutableStateFlow(ResultState.Loading())
//    val bikeListStateFlow: StateFlow<List<DomainBikeList>>
//        get() = _bikeListStateFlow

   fun getBikeListFlow(startIndex: Int, endIndex: Int) {
       modelScope.launch{
           isLoading.postValue(true)
           bikeListFlowUseCase(startIndex,endIndex).collect()
           {
               _bikeListFlow.value = it
               Log.e("viewModel", "새로고침됨 ", )
           }
           isLoading.postValue(false)
       }
    }

//    fun getBikeListFlow(startIndex: Int, endIndex: Int) {
//        modelScope.launch{
//            isLoading.postValue(true)
//            _bikeListFlow.value = bikeListFlowUseCase(startIndex, endIndex).asLiveData().value
//            isLoading.postValue(false)
//        }
//    }

//    fun getBikeList(startIndex: Int, endIndex: Int) {
//        modelScope.launch {
//            isLoading.postValue(true)
//            _bikeListLiveData.value = bikeListLiveDataUseCase(startIndex, endIndex)// 왜 invoke 함수가 nullable 인
//            isLoading.postValue(false)
//        }
//    }



}