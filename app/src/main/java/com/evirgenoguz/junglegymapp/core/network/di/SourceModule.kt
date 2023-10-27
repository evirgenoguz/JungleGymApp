package com.evirgenoguz.junglegymapp.core.network.di

import com.evirgenoguz.junglegymapp.core.network.source.rest.SampleDataSource
import com.evirgenoguz.junglegymapp.core.network.source.rest.SampleDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    @Singleton
    abstract fun bindSampleDataSource(sampleDataSourceImpl: SampleDataSourceImpl): SampleDataSource

}