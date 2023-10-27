package com.evirgenoguz.junglegymapp.core.network.source.rest

import com.evirgenoguz.junglegymapp.core.common.NetworkResult
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel

/**
 * Includes all rest package Api's functions as like blueprint
 * So if we have more than one api one have getCharacter other one has getCars
 * both of them has to be in that class.
 */
interface SampleDataSource {
    suspend fun sampleRequest(): NetworkResult<SampleResponseModel>
}