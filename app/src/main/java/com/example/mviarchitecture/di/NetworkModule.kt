package com.example.mviarchitecture.di

import com.example.mviarchitecture.data.repository.remote.Service
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
fun networkModule(baseUrl: String) = module {
    /**
     * OkHttp instances
     */
    single {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        interceptor
    }

    single {
        OkHttpClient().newBuilder().apply {
            addInterceptor(get<HttpLoggingInterceptor>())
            connectTimeout(45, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }
    }

    /**
     * Retrofit instances
     */
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient.Builder>().build())
            .baseUrl(baseUrl)
            .addConverterFactory(get<MoshiConverterFactory>())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    /**
     * Services instances
     */
    single {
        get<Retrofit>().create(Service::class.java)
    }
}