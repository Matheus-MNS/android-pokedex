package com.matheus.mendes.pokedex.pokemonlist.domain

import kotlinx.coroutines.flow.Flow

internal class PokemonListUseCase(
    private val repository: PokemonListRepository,
) {
    operator fun invoke(offset: Int): Flow<PokemonResult> = repository.getPokemonList(offset = offset)
}
