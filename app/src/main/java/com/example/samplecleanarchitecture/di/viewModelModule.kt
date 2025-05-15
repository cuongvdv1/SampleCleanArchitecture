package com.example.samplecleanarchitecture.di

import com.example.samplecleanarchitecture.ui.department.viewModel.DepartmentViewModel
import com.example.samplecleanarchitecture.ui.employee.viewModel.EmployeeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DepartmentViewModel(get()) }
    viewModel { EmployeeViewModel(get()) }
}
