package com.example.samplecleanarchitecture.ui.department.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetDepartmentUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepartmentViewModel(
    private val getDepartmentUseCase: GetDepartmentUseCase
): ViewModel() {

    fun getListDepartment() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}
