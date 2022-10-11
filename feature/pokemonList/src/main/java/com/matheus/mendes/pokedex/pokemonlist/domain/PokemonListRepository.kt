package com.matheus.mendes.pokedex.pokemonlist.domain

import kotlinx.coroutines.flow.Flow


internal interface PokemonListRepository {

    fun getPokemonList(offset: Int): Flow<PokemonResult>
}
