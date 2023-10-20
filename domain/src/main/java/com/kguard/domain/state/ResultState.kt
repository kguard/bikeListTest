package com.kguard.domain.state

sealed class ResultState<out R>{
    data class Success<out R>(val data: R): ResultState<R>()

    sealed class Fail : ResultState<Nothing>(){
        data class Error(val code: String, val message: String): Fail()
        data class Exception(val e: Throwable, val message: String):Fail()
    }
    data object Loading: ResultState<Nothing>()
}

