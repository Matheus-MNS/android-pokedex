package com.matheus.mendes.pokedex.pokemonlist.data.reposiroty

import com.matheus.mendes.pokedex.pokemonlist.data.remote.PokemonListRemoteDataSource
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonList
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

internal class PokemonListRepositoryImpl(
    private val remoteDataSource: PokemonListRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PokemonListRepository {
    override fun getPokemonList(): Flow<PokemonList> =
        remoteDataSource.getPokemonList().flowOn(dispatcher)
}
