package com.example.data.model

import com.example.domain.entities.EmployeeEntity
import com.google.gson.annotations.SerializedName

data class EmployeeData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("departmentCode")
    val departmentCode: String?
)

fun EmployeeData.toDomain() = EmployeeEntity(
    id = id,
    name = name,
    image = image,
    departmentCode = departmentCode
)
