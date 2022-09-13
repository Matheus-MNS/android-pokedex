package com.matheus.mendes.pokedex.pokemonlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonList
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import retrofit2.HttpException

const val ERROR = "Não foi possível conectar a pokedex"
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
                    pokemonListViewState.value = PokemonListViewState.Loading
                }
                .catch {
                    pokemonListViewState.value = PokemonListViewState.Error(ERROR)
                }
                .collect {
                    pokemonListViewState.value = PokemonListViewState.Success(it)
                }
        }
    }
}
