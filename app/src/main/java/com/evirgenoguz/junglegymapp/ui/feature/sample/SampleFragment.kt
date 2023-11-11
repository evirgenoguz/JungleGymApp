package com.evirgenoguz.junglegymapp.ui.feature.sample

import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.evirgenoguz.junglegymapp.core.common.base.BaseFragment
import com.evirgenoguz.junglegymapp.core.data.model.response.SampleResponseModel
import com.evirgenoguz.junglegymapp.databinding.FragmentSampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding>() {

    private val viewModel by viewModels<SampleViewModel>()

    override val bindingInflater: (LayoutInflater) -> FragmentSampleBinding
        get() = FragmentSampleBinding::inflate

    override fun setupUi() {
        initListeners()
        observeData()
    }

    private fun observeData() {
        viewModel.sampleLiveData.observe(viewLifecycleOwner) {result ->
            when {
                result.isError -> handleError()
                result.isLoading -> handleLoading()
                else -> handleSucces(result.data)
            }
        }
    }

    private fun handleSucces(data: SampleResponseModel?) {
        //buradaki data nullable olmamalı burakla bakmak lazım buna
        //Ekrana yazdırmalar
        //Recyclerview listesine göndermeler vs.
    }

    private fun handleLoading() {

    }

    private fun handleError() {

    }

    private fun initListeners() {
        binding.btnClickAndBoom.setOnClickListener {
            //viewModel.sampleRequest()
            Toast.makeText(requireContext(), "Button Clicked", Toast.LENGTH_LONG).show()
        }
    }


}