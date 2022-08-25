package com.matheus.mendes.pokedex.pokemonlist.data.remote

import com.matheus.mendes.pokedex.pokemonlist.domain.Pokemon
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PokemonListRemoteDataSource(private val service: PokemonListService) {

    fun getPokemonList(): Flow<PokemonList> = flow {
        emit(service.getPokemonList().toDomain())
    }

    private fun PokemonListResponse.toDomain() = PokemonList(
        count = count ?: 0,
        next = next.orEmpty(),
        previous = previous.orEmpty(),
        list = list?.toDomain() ?: emptyList()
    )

    private fun List<PokemonResponse>.toDomain() = this.map {
        Pokemon(
            name = it.name.orEmpty(),
            url = it.url.orEmpty()
        )
    }
}
