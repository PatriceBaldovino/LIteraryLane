package com.example.literarylane

var bookList = mutableListOf<Book>()

const val BOOK_ID_EXTRA = "bookExtra"

data class Book(
    val cover: Int,
    val author: String,
    val title: String,
    val description: String,
    val link: String,
    val id: Int
)
