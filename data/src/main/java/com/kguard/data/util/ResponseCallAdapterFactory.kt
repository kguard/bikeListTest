package com.kguard.data.util

import com.kguard.data.extension.ResponseState
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ResponseCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
//        1.매개변수로 들어온 returnType 즉 서비스 메서드에서 반환하는 자료형이 Call로 감싸져있는지 판단한다.
//        -> 어짜피 Call이 아니라면 CallAdapter를 거치고 뭐하고 할일도 없기에 여기서 조건을 충족하지 않는다면 null을 반환하여 이 팩토리에서 처리할수없음을 알린다
        if (Call::class.java != getRawType(returnType)){
            return null
        }
        check(returnType is ParameterizedType){
            "return type must be parameterized as Call<ResponseState<Foo>> or Call<ResponseState<out Foo>>"
        }
        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != ResponseState::class.java){
            return null
        }
        check(responseType is ParameterizedType){
            "Response must be parameterized as ResponseState<Foo> or ResponseState<out Foo>"
        }
        val bodyType = getParameterUpperBound(0, responseType)
        return ResponseCallAdapter<Any>(bodyType)
    }
}