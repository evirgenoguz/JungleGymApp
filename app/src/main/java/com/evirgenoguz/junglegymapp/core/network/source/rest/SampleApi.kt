package com.evirgenoguz.junglegymapp.core.network.source.rest

import com.evirgenoguz.junglegymapp.core.common.NetworkResult
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel
import retrofit2.http.GET

interface SampleApi {

    @GET("sample_request")
    suspend fun sampleRequest(): NetworkResult<SampleResponseModel>
}
