package com.example.literarylane

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.literarylane.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var bookLink: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle back button click
        binding.backButton.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish() // Close the current activity
        }

        val bookID = intent.getIntExtra(BOOK_ID_EXTRA, -1)
        val book = bookFromID(bookID)
        if (book != null) {
            binding.cover.setImageResource(book.cover)
            binding.title.text = book.title
            binding.description.text = book.description
            binding.author.text = book.author
            bookLink = book.link
        }

        binding.openLinkButton.setOnClickListener {
            bookLink?.let { url ->
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }
    }

    private fun bookFromID(bookID: Int): Book? {
        return bookList.find { it.id == bookID }
    }
}
