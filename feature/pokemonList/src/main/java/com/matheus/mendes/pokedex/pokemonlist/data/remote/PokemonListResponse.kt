package com.matheus.mendes.pokedex.pokemonlist.data.remote

import com.google.gson.annotations.SerializedName

internal data class PokemonListResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val list: List<PokemonResponse>?
)

internal data class PokemonResponse(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)