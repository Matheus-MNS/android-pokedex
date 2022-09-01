package com.matheus.mendes.pokedex.pokemonlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


internal class PokemonListViewModel(
    private val pokemonListUseCase: PokemonListUseCase
) : ViewModel() {

    val pokemonListViewState = MutableLiveData<PokemonListViewState>()

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            pokemonListUseCase()
                .onStart {
                    pokemonListViewState.value = PokemonListViewState.Loading(true)
                }
                .onCompletion {
                    pokemonListViewState.value = PokemonListViewState.Loading(false)
                }
                .catch {
                    pokemonListViewState.value = PokemonListViewState.Error
                }
                .collect {
                    pokemonListViewState.value = PokemonListViewState.Success(it)
                }
        }
    }
}
