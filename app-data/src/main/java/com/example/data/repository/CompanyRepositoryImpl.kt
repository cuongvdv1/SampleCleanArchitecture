package com.example.data.repository

import com.example.data.api.CompanyApi
import com.example.data.base.BaseRepository
import com.example.data.model.toDomain
import com.example.domain.entities.DepartmentEntity
import com.example.domain.entities.EmployeeEntity
import com.example.domain.repository.CompanyRepository
import com.example.domain.utils.ApiResult

class CompanyRepositoryImpl(private val api: CompanyApi) : BaseRepository(), CompanyRepository {

    override suspend fun getDepartment(): ApiResult<List<DepartmentEntity>> = safeApiCall {
        api.getDepartment().map { it.toDomain() }
    }

    override suspend fun getEmployee(departmentCode: String): ApiResult<List<EmployeeEntity>> = safeApiCall {
        api.getEmployee().filter { it.departmentCode == departmentCode }.map { it.toDomain() }
    }
}
