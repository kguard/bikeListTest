package com.kguard.bikelisttest.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kguard.bikelisttest.util.FetchState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.job
import kotlinx.coroutines.plus
import retrofit2.HttpException
import java.net.*

abstract class BaseViewModel : ViewModel() {
    protected val isLoading = MutableLiveData(false) // 로딩 관리 변수

    private var _fetchState = MutableLiveData<Pair<Throwable, FetchState>>() // 상태 관리 변수, 오류 관리
    val fetchState : LiveData<Pair<Throwable,FetchState>> get() = _fetchState

    private val job = SupervisorJob() // 오류를 부모 코루틴에 보내지 않는 코드

    protected  val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        isLoading.postValue(false) // postValue -> LiveData에서 백그라운드에서 값 변경, 로딩 상태 아니도록 만듬
        coroutineContext.job.cancel()
        throwable.printStackTrace()

        when(throwable){
            is SocketException -> _fetchState.value = Pair(throwable, FetchState.BAD_INTERNET)
            is HttpException -> _fetchState.value = Pair(throwable, FetchState.PARSE_ERROR)
            is UnknownHostException -> _fetchState.value = Pair(throwable, FetchState.WRONG_CONNECTION)
            is SocketTimeoutException -> _fetchState.value = Pair(throwable, FetchState.SOCKET_TIMEOUT_EXCEPTION)
            is IllegalStateException -> _fetchState.value = Pair(throwable, FetchState.IllegalStateException)
            else -> _fetchState.value = Pair(throwable, FetchState.FAIL)
        }
    }
    // 주로 modelScope 사용
    protected val modelScope = viewModelScope + job + exceptionHandler
    protected val ioScope = CoroutineScope(Dispatchers.IO) + job + exceptionHandler // 인터넷 작업을 위해서 보통 사용

    override fun onCleared() {
        super.onCleared()
        if (!job.isCancelled || !job.isCompleted)
            job.cancel()
    }

}