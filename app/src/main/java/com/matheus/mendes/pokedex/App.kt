package com.matheus.mendes.pokedex

import android.app.Application
import com.matheus.mendes.pokedex.data.remote.di.dataRemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataRemoteModule
            ).androidContext(applicationContext)
        }
    }
}