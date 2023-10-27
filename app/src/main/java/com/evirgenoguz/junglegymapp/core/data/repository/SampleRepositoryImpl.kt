package com.evirgenoguz.junglegymapp.core.data.repository

import com.evirgenoguz.junglegymapp.core.common.NetworkResult
import com.evirgenoguz.junglegymapp.core.common.ServerErrorModel
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel
import com.evirgenoguz.junglegymapp.core.network.source.rest.SampleDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val sampleDataSource: SampleDataSource,
) : SampleRepository {
    override suspend fun sampleRequest(): Flow<NetworkResult<SampleResponseModel>> {
        return flow {
            emit(NetworkResult.Loading)
            val response = sampleDataSource.sampleRequest()
            // Success emit edildildiğinde response içindeki veri maplenmesi gerekiyorsa
            // maplenerek gönderilmeli örnek olarak
            //  emit(ResponseState.Success(response.mapTo { it.toCharacterList() }))
            emit(NetworkResult.Success(SampleResponseModel(1, "deneme")))
        }.catch {
            emit(NetworkResult.Error(ServerErrorModel(it.message.orEmpty())))
        }
    }
}