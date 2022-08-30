package com.matheus.mendes.pokedex.pokemonlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matheus.mendes.pokedex.pokemonlist.R
import com.matheus.mendes.pokedex.pokemonlist.databinding.FragmentPokemonListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


internal class PokemonListFragment : Fragment(R.layout.fragment_pokemon_list) {
    private val binding by lazy { FragmentPokemonListBinding.inflate(layoutInflater) }
    private val viewModel: PokemonListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
