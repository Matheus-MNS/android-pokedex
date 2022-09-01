package com.matheus.mendes.pokedex.pokemonlist.di

import com.matheus.mendes.pokedex.pokemonlist.data.remote.PokemonListRemoteDataSource
import com.matheus.mendes.pokedex.pokemonlist.data.remote.PokemonListService
import com.matheus.mendes.pokedex.pokemonlist.data.reposiroty.PokemonListRepositoryImpl
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonListUseCase
import com.matheus.mendes.pokedex.pokemonlist.presentation.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val pokemonListModule = module {
    viewModel {
        PokemonListViewModel(
            pokemonListUseCase = PokemonListUseCase(
                repository = PokemonListRepositoryImpl(
                    remoteDataSource = PokemonListRemoteDataSource(
                        service = get<Retrofit>().create(PokemonListService::class.java)
                    )
                )
            )
        )
    }
}
