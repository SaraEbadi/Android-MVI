package com.example.mviarchitecture.feature

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
class MyViewModel: ViewModel() {

    @ExperimentalCoroutinesApi
    private val _intentChannel = ConflatedBroadcastChannel<MyViewModel>()

    init {
        _intentChannel
            .asFlow()
            .onEach {
                when(it){
                    My
                }
            }
    }
}