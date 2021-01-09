package com.example.mviarchitecture.base

import android.app.Application
import com.example.mviarchitecture.di.appcomponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

/**
 *
 * @author Sara Ebadi
 * @since 1/9/21
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        koinConfig()
    }

    private fun koinConfig() {
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            androidFileProperties()
            modules(appcomponent)
        }
    }
}