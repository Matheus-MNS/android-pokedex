package com.matheus.mendes.pokedex.pokemonlist.presentation

import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonList

sealed class PokemonListViewState {
    object Loading : PokemonListViewState()
    internal data class Success(val pokemonList: PokemonList) : PokemonListViewState()
    internal data class Error(val messageError: String) : PokemonListViewState()
}
