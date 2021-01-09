package com.example.mviarchitecture.di

import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
val moshiConverterModule = module {
    single {
        MoshiConverterFactory.create(get())
    }
}

/**
 * Represents builder of Moshi.
 */
val moshiModule = module {
    single {
        Moshi.Builder().build()
    }
}