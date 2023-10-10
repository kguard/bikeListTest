package com.kguard.bikelisttest.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kguard.bikelisttest.base.BaseViewModel
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.usecase.BikeListFlowUseCase
import com.kguard.domain.usecase.BikeListLiveDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
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

    private val _bikeListFlow: MutableLiveData<List<DomainBikeList>> = MutableLiveData()
    val bikeListFlow: LiveData<List<DomainBikeList>>
        get() = _bikeListFlow

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

    fun getBikeList(startIndex: Int, endIndex: Int) {
        modelScope.launch {
            isLoading.postValue(true)
            _bikeListLiveData.value =
                bikeListLiveDataUseCase(startIndex, endIndex)  // 왜 invoke 함수가 nullable 인
            isLoading.postValue(false)
        }
    }


}