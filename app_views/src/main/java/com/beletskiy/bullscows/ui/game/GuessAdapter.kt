package com.beletskiy.bullscows.ui.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beletskiy.bullscows.databinding.ItemGuessBinding
import com.beletskiy.bullscows.game.Guess

class GuessAdapter : ListAdapter<Guess, GuessViewHolder>(GuessDiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuessViewHolder =
        GuessViewHolder.from(parent)

    override fun onBindViewHolder(holder: GuessViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class GuessViewHolder private constructor(
    private val binding: ItemGuessBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Guess) {
        binding.guess = item
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GuessViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemGuessBinding.inflate(layoutInflater, parent, false)
            return GuessViewHolder(binding)
        }
    }
}

class GuessDiffItemCallback : DiffUtil.ItemCallback<Guess>() {

    override fun areItemsTheSame(oldItem: Guess, newItem: Guess): Boolean =
        oldItem.ordinal == newItem.ordinal

    override fun areContentsTheSame(oldItem: Guess, newItem: Guess): Boolean =
        oldItem == newItem
}
