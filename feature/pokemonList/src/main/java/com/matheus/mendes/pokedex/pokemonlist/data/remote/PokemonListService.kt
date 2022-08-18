package com.matheus.mendes.pokedex.pokemonlist.data.remote

import retrofit2.http.GET

internal interface PokemonListService {

    @GET("pokemon")
    suspend fun getPokemonList(): PokemonListResponse
}