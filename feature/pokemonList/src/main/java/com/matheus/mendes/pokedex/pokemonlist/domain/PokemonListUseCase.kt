package com.matheus.mendes.pokedex.pokemonlist.domain

import kotlinx.coroutines.flow.Flow

internal class PokemonListUseCase(
    private val repository: PokemonListRepository,
) {
    operator fun invoke(): Flow<PokemonList> = repository.getPokemonList()
}
