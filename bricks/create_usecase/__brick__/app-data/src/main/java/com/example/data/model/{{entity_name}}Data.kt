package {{package_name_data}}.model

import {{package_name_domain}}.entities.{{entity_name}}Entity

data class {{entity_name}}Data(
    val test: String?
)

fun {{entity_name}}Data.toDomain() = {{entity_name}}Entity(
    test = test
)
