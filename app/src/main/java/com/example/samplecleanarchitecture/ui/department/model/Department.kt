package com.example.samplecleanarchitecture.ui.department.model

import com.example.domain.entities.DepartmentEntity

data class Department (
    val id: Int?,
    val name: String,
    val image: String,
    val code: String
)

fun DepartmentEntity.toPresentation() = Department(
    id = id,
    name = name ?: "",
    image = image ?: "",
    code = code ?: ""
)
