package com.matheus.mendes.pokedex

import android.app.Application
import com.matheus.mendes.pokedex.data.remote.di.dataRemoteModule
import com.matheus.mendes.pokedex.pokemonlist.di.pokemonListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataRemoteModule(BuildConfig.BASE_URL),
                pokemonListModule
            ).androidContext(applicationContext)
        }
    }
}
