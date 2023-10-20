package com.kguard.data.extension




sealed class ResponseState<out T>{
    data class Success<out T>(val data: T): ResponseState<T>()

    sealed class Fail : ResponseState<Nothing>(){
        data class Error(val code: String, val message: String): Fail()
        data class Exception(val e: Throwable, val message: String):Fail()
    }
}
