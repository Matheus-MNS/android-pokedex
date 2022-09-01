package com.matheus.mendes.pokedex.pokemonlist.presentation

import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonList

internal sealed class PokemonListViewState {
    data class Loading(val isLoading: Boolean) : PokemonListViewState()
    data class Success(val pokemonList: PokemonList) : PokemonListViewState()
    object Error : PokemonListViewState()
}
