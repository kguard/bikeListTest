package com.kguard.data.extension

import com.kguard.domain.state.Failure
import retrofit2.Response
import java.io.IOException

inline fun <reified T : Any> Response<T>.errorHandler(): ErrorState<T>{
    return try {
        when(this.code()){
            404 -> ErrorState.Error(failure = Failure.BadRequest)
            else->{
                val body = this.body()
                return if(body == null){
                    ErrorState.Error(failure = Failure.UnHandleError())
                }else{
                    ErrorState.Success(data = body as T)
                }
            }
        }
    }catch (e: IOException){
        ErrorState.Error(failure = Failure.NetworkConnection)
    }catch (t: Throwable){
       ErrorState.Error(failure = Failure.UnHandleError())
    }
}