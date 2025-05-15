package com.example.samplecleanarchitecture.ui.department.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecase.GetDepartmentUseCase
import com.example.samplecleanarchitecture.base.BaseViewModel
import com.example.samplecleanarchitecture.ui.department.model.Department
import com.example.samplecleanarchitecture.ui.department.model.toPresentation

class DepartmentViewModel(
    private val getDepartmentUseCase: GetDepartmentUseCase
) : BaseViewModel() {

    private val _department = MutableLiveData<List<Department>>()
    val department: LiveData<List<Department>> get() = _department

    fun getListDepartment() {
        runAsyncWithLoading(
            request = { getDepartmentUseCase.execute() },
            onSuccess = { result ->
                val data = result.map { it.toPresentation() }
                _department.postValue(data)
            }
        )
    }
}
