package com.example.samplecleanarchitecture.di

import com.example.domain.usecase.GetDepartmentUseCase
import com.example.domain.usecase.GetEmployeeUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetDepartmentUseCase(get()) }
    single { GetEmployeeUseCase(get()) }
}
