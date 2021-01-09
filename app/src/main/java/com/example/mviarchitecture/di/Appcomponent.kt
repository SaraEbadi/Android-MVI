package com.example.mviarchitecture.di

import com.example.mviarchitecture.BuildConfig

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
val appcomponent = listOf(
    viewModelModule,
    repositoryModule,
    moshiModule,
    moshiConverterModule,
    networkModule(BuildConfig.BASE_URL)
)