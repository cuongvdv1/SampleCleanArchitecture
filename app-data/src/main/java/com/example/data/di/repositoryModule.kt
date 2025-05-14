package com.example.data.di

import com.example.data.repository.CompanyRepositoryImpl
import com.example.domain.repository.CompanyRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CompanyRepository> { CompanyRepositoryImpl(get()) }
}
