package com.matheus.mendes.pokedex.pokemonlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.matheus.mendes.pokedex.pokemonlist.R
import com.matheus.mendes.pokedex.pokemonlist.databinding.FragmentPokemonListBinding
import com.matheus.mendes.pokedex.pokemonlist.domain.PokemonList
import com.matheus.mendes.pokedex.pokemonlist.presentation.adapter.PokemonListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


internal class PokemonListFragment : Fragment(R.layout.fragment_pokemon_list) {
    private val binding by lazy { FragmentPokemonListBinding.inflate(layoutInflater) }
    private val viewModel: PokemonListViewModel by viewModel()
    private val pokemonListAdapter = PokemonListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observerState()
    }

    private fun observerState() {
        viewModel.pokemonListViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is PokemonListViewState.Loading -> handleLoading(true)
                is PokemonListViewState.Success -> handleSuccess(state.pokemonList)
                is PokemonListViewState.Error -> handleError(state.messageId)
            }
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        binding.loadingProgressAnimation.isVisible = isLoading
    }

    private fun handleSuccess(pokemonList: PokemonList) {
        handleLoading(false)
        pokemonListAdapter.submitList(pokemonList.list)
        binding.repositoriesRecyclerView.adapter = pokemonListAdapter
    }

    private fun handleError(messageId: Int) {
        handleLoading(false)
        Toast.makeText(context, messageId, Toast.LENGTH_LONG).show()
    }
}
