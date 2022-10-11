package com.matheus.mendes.pokedex.pokemonlist.domain

internal data class PokemonResult(
    val count: Int,
    val next: String,
    val previous: String,
    val list: List<Pokemon>
)

internal data class Pokemon(
    val id: String,
    val name: String,
    val url: String,
    val imageUrl: String,
)
