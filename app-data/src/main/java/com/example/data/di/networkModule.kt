package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.api.CompanyApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get())  }
    single { provideCompanyApi(get()) }
}


private fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://68244b5365ba05803399a88c.mockapi.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideCompanyApi(retrofit: Retrofit) = retrofit.create(CompanyApi::class.java)
