package {{package_name_domain}}.usecase

import {{package_name_domain}}.entities.{{entity_name}}Entity
import {{package_name_domain}}.repository.{{repository_name}}Repository
import {{package_name_domain}}.utils.ApiResult

class {{usecase_name.pascalCase()}}UseCase(private val repository: {{repository_name}}Repository) {

    suspend fun execute(): ApiResult<List<{{entity_name}}Entity>> {
        return repository.{{usecase_name}}()
    }
}
