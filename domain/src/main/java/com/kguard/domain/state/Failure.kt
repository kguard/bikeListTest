package com.kguard.domain.state

import com.kguard.domain.utils.Constants


sealed class Failure(val message: String){
    data object BadRequest: Failure(Constants.TOAST_ERROR_NOT_FOUND)
    data object NetworkConnection: Failure(Constants.TOAST_ERROR_INTERNET_CONNECTED)
    class UnHandleError(message: String = Constants.TOAST_ERROR_UNHANDLED): Failure(message)
}
