package com.matheus.mendes.pokedex.pokemonlist.presentation

import com.matheus.mendes.pokedex.pokemonlist.domain.Pokemon

internal sealed class PokemonListViewState {
    object Loading : PokemonListViewState()
    data class Success(val pokemonList: List<Pokemon>) : PokemonListViewState()
    data class Error(val messageId: Int) : PokemonListViewState()
}
