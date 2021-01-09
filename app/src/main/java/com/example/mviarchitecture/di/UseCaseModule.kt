package com.example.mviarchitecture.di

import com.example.mviarchitecture.data.MyUseCase
import org.koin.dsl.module

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
val useCaseModule = module {
    factory { MyUseCase() }
}