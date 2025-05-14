package com.example.data.api

import com.example.data.model.DepartmentData
import retrofit2.http.GET

interface CompanyApi {

    @GET("Department")
    fun getDepartment(): List<DepartmentData>
}
