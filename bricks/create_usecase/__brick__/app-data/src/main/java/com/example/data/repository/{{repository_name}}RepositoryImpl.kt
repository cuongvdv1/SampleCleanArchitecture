package {{package_name_data}}.repository

import {{package_name_data}}.api.CompanyApi
import {{package_name_data}}.base.BaseRepository
import {{package_name_domain}}.entities.{{entity_name}}Entity
import {{package_name_domain}}.repository.{{repository_name}}Repository
import {{package_name_domain}}.utils.ApiResult

class {{repository_name}}RepositoryImpl(private val api: CompanyApi) : BaseRepository(), {{repository_name}}Repository {

    override suspend fun {{usecase_name}}(): ApiResult<List<{{entity_name}}Entity>> = safeApiCall {
        TODO("implement logic")
    }
}