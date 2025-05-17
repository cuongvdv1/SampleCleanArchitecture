package {{package_name_domain}}.repository

import {{package_name_domain}}.entities.{{entity_name}}Entity
import {{package_name_domain}}.utils.ApiResult

interface {{repository_name}}Repository {

    suspend fun {{usecase_name}}(): ApiResult<List<{{entity_name}}Entity>>
}
