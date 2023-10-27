package com.evirgenoguz.junglegymapp.core.network.source.rest

import com.evirgenoguz.junglegymapp.core.common.NetworkResult
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel
import javax.inject.Inject

class SampleDataSourceImpl @Inject constructor(private val sampleApi: SampleApi) :
    SampleDataSource {

    override suspend fun sampleRequest(): NetworkResult<SampleResponseModel> =
        sampleApi.sampleRequest()

}