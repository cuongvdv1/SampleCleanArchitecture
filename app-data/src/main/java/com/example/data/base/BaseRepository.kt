package com.example.data.base

import com.example.domain.utils.ApiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository {

    suspend fun <R> safeApiCall(
        context: CoroutineContext = Dispatchers.IO,
        request: suspend CoroutineScope.() -> R
    ): ApiResult<R> = withContext(context) {
        return@withContext try {
            ApiResult.Success(request())
        } catch (e: HttpException) {
            ApiResult.Error(e.code(), e.message(), e.response()?.errorBody()?.string())
        } catch (e: Exception) {
            ApiResult.Error(null, e.message)
        }
    }
}
