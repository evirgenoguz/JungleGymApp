package com.evirgenoguz.junglegymapp.core.network.di

import com.evirgenoguz.junglegymapp.core.common.Constants
import com.evirgenoguz.junglegymapp.core.network.source.rest.SampleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSampleApi(retrofit: Retrofit): SampleApi {
        return retrofit.create(SampleApi::class.java)
    }
}