package com.example.domain.usecase

import com.example.domain.entities.EmployeeEntity
import com.example.domain.repository.CompanyRepository
import com.example.domain.utils.ApiResult

class GetEmployeeUseCase(private val repository: CompanyRepository) {

    suspend fun execute(departmentCode: String): ApiResult<List<EmployeeEntity>> {
        if (departmentCode.isBlank() || departmentCode.endsWith("D").not()) {
            return ApiResult.Error(null, "Invalid department code")
        }
        return repository.getEmployee(departmentCode)
    }
}
