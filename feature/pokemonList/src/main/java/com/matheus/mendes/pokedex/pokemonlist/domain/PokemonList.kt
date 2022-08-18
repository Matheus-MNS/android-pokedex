package com.matheus.mendes.pokedex.pokemonlist.domain

internal data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val list: List<Pokemon>
)

internal data class Pokemon(
    val name: String,
    val url: String
)


