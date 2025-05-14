package com.example.data.model

import com.example.domain.entities.DepartmentEntity
import com.google.gson.annotations.SerializedName

data class DepartmentData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("code")
    val code: String?
)

fun DepartmentData.toDomain() = DepartmentEntity(
    id = id,
    name = name,
    image = image,
    code = code
)
