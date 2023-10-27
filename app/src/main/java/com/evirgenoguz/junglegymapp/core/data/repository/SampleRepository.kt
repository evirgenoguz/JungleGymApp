package com.evirgenoguz.junglegymapp.core.data.repository

import com.evirgenoguz.junglegymapp.core.common.NetworkResult
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel
import kotlinx.coroutines.flow.Flow

interface SampleRepository {

    suspend fun sampleRequest(): Flow<NetworkResult<SampleResponseModel>>

}