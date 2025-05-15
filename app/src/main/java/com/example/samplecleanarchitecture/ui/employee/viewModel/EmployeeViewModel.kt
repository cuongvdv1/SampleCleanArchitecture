package com.example.samplecleanarchitecture.ui.employee.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecase.GetEmployeeUseCase
import com.example.samplecleanarchitecture.base.BaseViewModel
import com.example.samplecleanarchitecture.ui.employee.model.Employee
import com.example.samplecleanarchitecture.ui.employee.model.toPresentation

class EmployeeViewModel(
    private val getEmployeeUseCase: GetEmployeeUseCase
): BaseViewModel() {

    private val _employee = MutableLiveData<List<Employee>>()
    val employee: LiveData<List<Employee>> get() = _employee

    fun getListEmployee(departmentCode: String) {
        runAsyncWithLoading(
            request = { getEmployeeUseCase.execute(departmentCode) },
            onSuccess = { result ->
                val data = result.map { it.toPresentation() }
                _employee.postValue(data)
            }
        )
    }

    fun selectEmployee(employee: Employee) {
        val newList = _employee.value?.map {
            if (it.id == employee.id) {
                it.copy(isSelected = it.isSelected.not())
            } else {
                it
            }
        } ?: emptyList()
        _employee.value = newList.toList()
    }

    fun deleteEmployee() {
        val currentList = _employee.value?.toMutableList() ?: mutableListOf()
        currentList.removeIf { it.isSelected }
        _employee.value = currentList.toList()
    }
}