package com.kguard.bikelisttest.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kguard.data.BuildConfig
import com.kguard.data.util.ResponseCallAdapter
import com.kguard.data.util.ResponseCallAdapterFactory
import com.kguard.data.util.ResponseInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private var gson: Gson = GsonBuilder().setLenient().create()
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://openapi.seoul.go.kr:8088/")
            .client(provideOkHttpClient())
            .addCallAdapterFactory(ResponseCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideOkHttpLogging())
            .addInterceptor(provideResponseInterceptor())
//            .addInterceptor{
//                val request = it.request()
//                    .newBuilder()
//                    .build()
//                // Response
//                val response = it.proceed(request)
//                response
//            }
            .build()
    }
    @Provides
    @Singleton
    fun provideResponseInterceptor() : ResponseInterceptor{
        return ResponseInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}