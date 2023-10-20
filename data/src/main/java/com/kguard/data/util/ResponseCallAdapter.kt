package com.kguard.data.util

import com.kguard.data.extension.ResponseState
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

// 정상적으로 나가던 Call객체를 가로채서 내가 원하는 처리를 하여 내보내는것
class ResponseCallAdapter<R: Any>(private val responseType: Type):CallAdapter<R, Call<ResponseState<R>>>{

     //어댑터가 HTTP 응답을 자바 오브젝트로 변환할 때 반환값으로 지정할 타입을 리턴하는 메서드(어떤 자바객체로 바꿀것인지 자료형을 지정하는 메서드).
     //Factory에서 받아온 Call 객체에서 필요없는 부분 걷어내고 매개변수(responseType)로 전달해준다.
    override fun responseType(): Type = responseType

    //메서드의 파리미터로 받은 call에게 작업을 위임하는 T 타입 인스턴스를 반환
    override fun adapt(call: Call<R>): Call<ResponseState<R>> = ResponseCall(call)
}