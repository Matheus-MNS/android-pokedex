package com.matheus.mendes.pokedex.pokemonlist.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

private const val LIST_LIMIT = 20

internal interface PokemonListService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = LIST_LIMIT,
        @Query("offset") offset: Int,
    ): PokemonListResponse

}
