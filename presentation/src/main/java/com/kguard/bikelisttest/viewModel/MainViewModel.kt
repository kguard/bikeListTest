package com.kguard.bikelisttest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kguard.bikelisttest.base.BaseViewModel
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.usecase.BikeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val bikeListUseCase: BikeListUseCase):BaseViewModel() {
    private var _bikeList : MutableLiveData<List<DomainBikeList>> = MutableLiveData()
    val bikeList : LiveData<List<DomainBikeList>>
        get() = _bikeList

    fun getBikeList(startIndex :Int, endIndex:Int){
        modelScope.launch {
            isLoading.postValue(true)
            _bikeList.value=bikeListUseCase.getBikeList(startIndex, endIndex)
            isLoading.postValue(false)
        }
    }
}