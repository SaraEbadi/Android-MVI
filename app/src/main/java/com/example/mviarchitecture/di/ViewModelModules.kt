package com.example.mviarchitecture.di

import com.example.mviarchitecture.feature.MyViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
val viewModelModule = module {
    viewModel { MyViewModel() }
}