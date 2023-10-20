package com.kguard.data.util

import android.util.Log
import com.google.gson.Gson
import com.kguard.data.extension.ResponseState
import com.kguard.data.model.dto.ResultRes
import com.kguard.domain.utils.Constants
import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ResponseCall<T>(private val call: Call<T>) : Call<ResponseState<T>> {

    override fun enqueue(callback: Callback<ResponseState<T>>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                val code = response.code()
                val message = response.message()
                val error = response.errorBody()
                Log.e("ResponseCall", "onResponse: reponse ${response}  ", )
                Log.e("ResponseCall", "onResponse:body ${body.toString()}" )
                Log.e("ResponseCall", "onResponse:errorbody ${error.toString()}" )
                if (response.isSuccessful){
                    if (body != null){
                        // response가 성공적이고 body가 비어 있지 않을때 1
                        Log.e("ResponseCall", "onResponse: 1 ", )
                        callback.onResponse(this@ResponseCall,Response.success(ResponseState.Success(body)))
                    }
                    else{
                         //response가 성공적이나 body가 비어 있을때(타입이 다를때) 2
                        Log.e("ResponseCall", "onResponse: 2 ", )
                        //val errorResponse = Gson().fromJson(error.toString(),ResultRes::class.java)
                        callback.onResponse(this@ResponseCall,Response.success(ResponseState.Fail.Error(code.toString(),message)))

                    }
                }else{
                    //이 상황은 코드가 200이상 300미만이 아닌경우 3
                    Log.e("ResponseCall", "onResponse: 3 ", )
                    //val errorResponse = Gson().fromJson(error.toString(),ResultRes::class.java)
                    callback.onResponse(this@ResponseCall,Response.success(ResponseState.Fail.Error(code.toString(),message)))
                }
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                 val errorResponse = when(t){
                     is IOException -> ResponseState.Fail.Exception(t,Constants.ERROR_INTERNET_CONNECTED)
                     else -> ResponseState.Fail.Exception(t,"")
                 }
                callback.onResponse(this@ResponseCall,Response.success(errorResponse))
            }

        })
    }

    override fun clone(): Call<ResponseState<T>> = ResponseCall(call.clone())
    override fun execute(): Response<ResponseState<T>> {
        return Response.success(ResponseState.Success(call.execute().body()!!))
        //throw UnsupportedOperationException("커스텀한 callAdapter에서는 execute 사용 x")
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() = call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled

    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()

}