package com.example.literarylane

import androidx.recyclerview.widget.RecyclerView
import com.example.literarylane.databinding.CardCellBinding

class CardViewHolder(
    private val binding: CardCellBinding,
    private val clickListener: BookClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindBook(book: Book) { //Card Cell elements
        binding.cover.setImageResource(book.cover)
        binding.title.text = book.title
        binding.author.text = book.author
        binding.root.setOnClickListener {
            clickListener.onClick(book)
        }
    }
}
