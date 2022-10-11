package com.matheus.mendes.pokedex.pokemonlist.data.mapper

import com.matheus.mendes.pokedex.pokemonlist.data.remote.PokemonListResponse
import com.matheus.mendes.pokedex.pokemonlist.data.remote.PokemonResponse
import com.matheus.mendes.pokedex.pokemonlist.domain.Pokemon
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonResult

private const val POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/"
private const val IMAGE_URL = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
private const val FORWARD_SLASH = "/"
private const val EMPTY_STRING = ""
private const val PAD_START_LENGTH = 3
private const val PAD_CHAR = '0'
private const val PNG = ".png"

internal fun PokemonListResponse.toDomain() = PokemonResult(
    count = count ?: 0,
    next = next.orEmpty(),
    previous = previous.orEmpty(),
    list = list?.toDomain() ?: emptyList()
)

private fun List<PokemonResponse>.toDomain() = this.map {
    val id = getId(it.url)
    Pokemon(
        id = id,
        name = it.name.orEmpty(),
        url = it.url.orEmpty(),
        imageUrl = getImageUrl(id)

    )
}

fun getId(url: String?): String {
    val id = url
        ?.replace(POKEMON_URL, EMPTY_STRING)
        ?.replace(FORWARD_SLASH, EMPTY_STRING)?.toInt()
    return id.toString().padStart(PAD_START_LENGTH, PAD_CHAR)
}

private fun getImageUrl(id: String?): String = IMAGE_URL + id + PNG
