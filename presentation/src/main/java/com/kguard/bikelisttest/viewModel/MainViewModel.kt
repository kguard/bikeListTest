package com.kguard.bikelisttest.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kguard.bikelisttest.base.BaseViewModel
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.state.ResultState
import com.kguard.domain.usecase.BikeListFlowUseCase
import com.kguard.domain.usecase.BikeListLiveDataUseCase
import com.kguard.domain.usecase.BikeListWithResponseStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bikeListLiveDataUseCase: BikeListLiveDataUseCase,
    private val bikeListFlowUseCase: BikeListFlowUseCase,
    private val bikeListWithResponseStateUseCase: BikeListWithResponseStateUseCase
) :
    BaseViewModel() {
    private val _bikeListLiveData: MutableLiveData<List<DomainBikeList>> = MutableLiveData() //1
    val bikeListLiveData: LiveData<List<DomainBikeList>>
        get() = _bikeListLiveData

    // viewModel에서 flow를 사용하지 않는 이유: flow는 생명주기를 모르기 때문에 viewModel에서 데이터를 받아와야한다고 생각
    private val _bikeListFlow: MutableLiveData<List<DomainBikeList>> = MutableLiveData() //2
    val bikeListFlow: LiveData<List<DomainBikeList>>
        get() = _bikeListFlow


    private val _bikeListStateFlow = MutableStateFlow<List<DomainBikeList>>(emptyList()) //3
    val bikeListStateFlow: StateFlow<List<DomainBikeList>>
        get() = _bikeListStateFlow

    private val _bikeListStateFlowWithResponse =
        MutableStateFlow<ResultState<List<DomainBikeList>>>(ResultState.Loading) //4
    val bikeListStateFlowWithResponse: StateFlow<ResultState<List<DomainBikeList>>>
        get() = _bikeListStateFlowWithResponse


    fun getBikeList(startIndex: Int, endIndex: Int) { //1
        modelScope.launch {
            isLoading.postValue(true)
            //_bikeListLiveData.value = bikeListLiveDataUseCase.invoke(startIndex, endIndex)// 왜 invoke 함수가 nullable 인
            _bikeListLiveData.value = bikeListFlowUseCase(startIndex, endIndex).asLiveData().value
            isLoading.postValue(false)
        }
    }


    fun getBikeListFlow(startIndex: Int, endIndex: Int) { //2
        modelScope.launch {
            isLoading.postValue(true)
            //_bikeListFlow.value = bikeListFlowUseCase(startIndex, endIndex).asLiveData().value
            bikeListFlowUseCase(startIndex, endIndex).collect()
            {
                _bikeListFlow.value = it
                Log.e("viewModel", "새로고침됨 ")
            }
            isLoading.postValue(false)
        }
    }

    fun getBikeListStateFlow(startIndex: Int, endIndex: Int) { //3
        modelScope.launch {
//            bikeListFlowUseCase(startIndex,endIndex).collect(){
//                _bikeListStateFlow.value = it
//            }
            //_bikeListStateFlow.value = bikeListFlowUseCase(startIndex, endIndex).asLiveData().value!!
            _bikeListStateFlow.value = bikeListLiveDataUseCase(startIndex, endIndex)
        }
    }

    fun getBikeListWithResponseState(startIndex: Int, endIndex: Int) { //4
        modelScope.launch {
            _bikeListStateFlowWithResponse.value = bikeListWithResponseStateUseCase(startIndex, endIndex)
            when(val usecase  = bikeListWithResponseStateUseCase(startIndex, endIndex))
            {
                is ResultState.Success -> _bikeListStateFlowWithResponse.value = usecase
                is ResultState.Fail.Exception -> {when(val exception = usecase.e){
                    is TimeoutException -> ResultState.Fail.Exception(exception,"시간초과")
                }
                }is ResultState.Loading -> {}

            }

        }
    }




}