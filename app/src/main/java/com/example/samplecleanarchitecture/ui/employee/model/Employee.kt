package com.example.samplecleanarchitecture.ui.employee.model

import com.example.domain.entities.EmployeeEntity

data class Employee(
    val id: Int?,
    val name: String,
    val image: String,
    val isSelected: Boolean = false
)

fun EmployeeEntity.toPresentation() = Employee(
    id = id,
    name = name ?: "",
    image = image ?: ""
)
