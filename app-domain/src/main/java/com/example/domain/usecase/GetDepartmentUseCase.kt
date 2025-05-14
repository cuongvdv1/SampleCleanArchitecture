package com.example.domain.usecase

import com.example.domain.entities.DepartmentEntity
import com.example.domain.repository.CompanyRepository
import com.example.domain.utils.ApiResult

class GetDepartmentUseCase(private val repository: CompanyRepository) {

    suspend fun execute(): ApiResult<List<DepartmentEntity>> {
        return repository.getDepartment()
    }
}
