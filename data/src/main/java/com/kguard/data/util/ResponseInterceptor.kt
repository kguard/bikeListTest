package com.kguard.data.util

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONObject
import java.lang.Exception

class ResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val responseJson = response.extractResponseJson()

//        val dataPayload = if (responseJson.has(KEY_rentBikeStatus))
//            responseJson[KEY_rentBikeStatus] else EMPTY_JSON
//        val dataPayloadError = if(responseJson.has(KEY_RESULT))
//            responseJson[KEY_RESULT].to else EMPTY_JSON
//        val a = JSONObject(dataPayloadError.toString())
//
//        Log.e("TAG", "intercept: ${a["CODE"]} ")
//        return response.newBuilder().body(dataPayload.toString().toResponseBody()).build()

        return if (responseJson.has(KEY_RESULT)) {
            val errorRes = JSONObject(responseJson[KEY_RESULT].toString())
            val code = errorRes[KEY_CODE].toString().replace("ERROR-","").toInt()
            val message = errorRes[KEY_MESSAGE].toString()
            response.newBuilder().code(code).message(message).body(EMPTY_JSON.toResponseBody()).build()
        } else if (responseJson.has(KEY_rentBikeStatus)){
            val rightRes = responseJson[KEY_rentBikeStatus].toString().toResponseBody()
            response.newBuilder().body(rightRes).build()
        } else {
            response
        }


//       return when(responseJson)
//        {
//           responseJson.has(KEY_RESULT) -> {
//               val errorRes = JSONObject(responseJson[KEY_RESULT].toString())
//               val code = errorRes[KEY_CODE].toString().replace("ERROR-", "").toInt()
//               val message = errorRes[KEY_MESSAGE].toString()
//               response.newBuilder().code(code).message(message).body(EMPTY_JSON.toResponseBody())
//                   .build()
//           }
//           responseJson.has(KEY_rentBikeStatus) -> {
//               val rightRes = responseJson[KEY_rentBikeStatus].toString().toResponseBody()
//               response.newBuilder().body(rightRes).build()
//           }
//           else -> response
//        }

    }

    private fun Response.extractResponseJson(): JSONObject {
        val jsonString = this.body?.string()
        return try {
            JSONObject(jsonString)
        } catch (exception: Exception) {
            Log.e("interceptor", "서버 응답이 json이 아님: $jsonString")
            throw exception
        }
    }

    companion object {
        private const val EMPTY_JSON = "{}"

        //private const val KEY_MESSAGE = "message"
        private const val KEY_RESULT = "RESULT"
        private const val KEY_BikeListTestRes = "BikeListTestRes"
        private const val KEY_rentBikeStatus = "rentBikeStatus"
        private const val KEY_ROW = "row"
        private const val KEY_CODE ="CODE"
        private const val KEY_MESSAGE = "MESSAGE"
    }
}