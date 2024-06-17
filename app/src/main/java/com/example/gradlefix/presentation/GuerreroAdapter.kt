package com.example.gradlefix.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gradlefix.R
import com.example.gradlefix.model.Item

class GuerreroAdapter: PagingDataAdapter<Item, GuerreroAdapter.GuerreroViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuerreroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_guerrero, parent, false)
        return GuerreroViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuerreroViewHolder, position: Int) {
        val pokemon = getItem(position)
        pokemon?.let { holder.bind(it) }
    }

    class GuerreroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.textViewNameGuerrero)
        private val countPokemon: TextView = view.findViewById(R.id.countGuerrero)

        fun bind(pokemon: Item) {
            nameTextView.text = pokemon.name
            countPokemon.text = (position + 1).toString()
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }
}