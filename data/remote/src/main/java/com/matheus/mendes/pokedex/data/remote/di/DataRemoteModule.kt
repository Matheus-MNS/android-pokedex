package com.matheus.mendes.pokedex.data.remote.di

import com.matheus.mendes.pokedex.data.remote.WebServiceFactory.provideRetrofit
import org.koin.dsl.module

val dataRemoteModule = module{
    single{
        provideRetrofit()
    }
}