package com.evirgenoguz.junglegymapp.core.data.di

import com.evirgenoguz.junglegymapp.core.data.repository.SampleRepository
import com.evirgenoguz.junglegymapp.core.data.repository.SampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSampleRepository(sampleRepositoryImpl: SampleRepositoryImpl): SampleRepository

}