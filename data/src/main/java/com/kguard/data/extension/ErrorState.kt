package com.kguard.data.extension

import com.kguard.domain.state.Failure


sealed class ErrorState<T>{
    data class Success<T>(val data: T): ErrorState<T>()
    data class Error<T>(val failure: Failure = Failure.UnHandleError() ): ErrorState<T>()
}
