package com.matheus.mendes.pokedex.pokemonlist.data.remote

import com.matheus.mendes.pokedex.pokemonlist.data.mapper.toDomain
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PokemonListRemoteDataSource(private val service: PokemonListService) {

    fun getPokemonList(offset: Int): Flow<PokemonResult> = flow {
        emit(service.getPokemonList(offset = offset).toDomain())
    }
}
