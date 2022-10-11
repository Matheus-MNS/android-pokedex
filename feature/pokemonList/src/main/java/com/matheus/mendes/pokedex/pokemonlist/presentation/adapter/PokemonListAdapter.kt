package com.matheus.mendes.pokedex.pokemonlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mendes.pokedex.pokemonlist.databinding.ItemPokemonBinding
import com.matheus.mendes.pokedex.pokemonlist.domain.Pokemon
import com.matheus.mendes.pokedex.pokemonlist.utils.DefaultDiffCallback
import com.squareup.picasso.Picasso

internal class PokemonListAdapter : ListAdapter<Pokemon, PokemonListAdapter.ViewHolder>(
    DefaultDiffCallback<Pokemon>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonItem: Pokemon) {
            with(binding) {
                pokemonNumberTextView.text = "#" + pokemonItem.id
                pokemonNameTextView.text = pokemonItem.name.replaceFirstChar { it.uppercase() }
                Picasso.get()
                    .load(pokemonItem.imageUrl)
                    .into(pokemonImageView)
            }
        }
    }
}
