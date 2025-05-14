package com.example.samplecleanarchitecture

import android.app.Application
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.samplecleanarchitecture.di.useCaseModule
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = listOf(
            networkModule,
            repositoryModule,
            useCaseModule
        )
        startKoin {
            modules(modules)
        }
    }
}
