package com.matheus.mendes.pokedex.pokemonlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mendes.pokedex.pokemonlist.R
import com.matheus.mendes.pokedex.pokemonlist.domain.Pokemon
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.net.UnknownHostException

internal class PokemonListViewModel(
    private val pokemonListUseCase: PokemonListUseCase
) : ViewModel() {
    private var offset: Int = 0
    private var pokemonList: List<Pokemon> = emptyList()
    val pokemonListViewState = MutableLiveData<PokemonListViewState>()

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            pokemonListUseCase(offset)
                .onStart {
                    pokemonListViewState.value = PokemonListViewState.Loading
                }
                .catch {
                    pokemonListViewState.value = PokemonListViewState.Error(getErrorMessage(it))
                }
                .collect {
                    pokemonList = pokemonList + it.list
                    pokemonListViewState.value = PokemonListViewState.Success(pokemonList)
                    offset += it.list.size
                }
        }
    }

    private fun getErrorMessage(throwable: Throwable) = when (throwable) {
        is UnknownHostException ->
            R.string.error_no_connection
        else ->
            R.string.error_message
    }
}
