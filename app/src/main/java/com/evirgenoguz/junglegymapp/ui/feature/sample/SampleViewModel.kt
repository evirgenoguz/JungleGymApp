package com.evirgenoguz.junglegymapp.ui.feature.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.junglegymapp.core.common.NetworkResult
import com.evirgenoguz.junglegymapp.core.common.base.BaseViewModel
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel
import com.evirgenoguz.junglegymapp.core.data.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Eğer use case kullanılıyorsa constructorda sampleRepository yerine useCase çağrılıyor.
@HiltViewModel
class SampleViewModel @Inject constructor(private val sampleRepository: SampleRepository) :
    BaseViewModel() {

    private val _sampleLiveData = MutableLiveData(SampleScreenUiState.initial())
    val sampleLiveData: LiveData<SampleScreenUiState> get() = _sampleLiveData

    fun sampleRequest() {
        viewModelScope.launch {
            sampleRepository.sampleRequest().collect { responseState ->
                when (responseState) {
                    is NetworkResult.Error -> {
                        _sampleLiveData.postValue(
                            SampleScreenUiState(
                                isError = true, errorMessage = responseState.error.message
                            )
                        )
                    }

                    NetworkResult.Loading -> {
                        _sampleLiveData.postValue(SampleScreenUiState(isLoading = true))
                    }

                    is NetworkResult.Success -> {
                        _sampleLiveData.postValue(SampleScreenUiState(data = responseState.body))
                    }
                }
            }
        }
    }

}

data class SampleScreenUiState(
    val data: SampleResponseModel? = null, //burada bir değişiklik lazım gibi
    val isLoading: Boolean = false, val isError: Boolean = false, val errorMessage: String? = ""
) {
    companion object {
        fun initial() = SampleScreenUiState(isLoading = true)
    }
}