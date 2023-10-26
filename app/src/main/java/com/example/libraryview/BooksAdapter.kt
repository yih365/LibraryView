package com.example.libraryview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BooksAdapter(private val context: Context, private val booksList: List<BookDetail>):
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTV = itemView.findViewById<TextView>(R.id.titleTV)
        private val coverIV = itemView.findViewById<ImageView>(R.id.coverIV)

        fun bind(book: BookDetail) {
            titleTV.text = book.title
            Glide.with(context).load(book.coverUrl)
                .into(coverIV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksAdapter.ViewHolder, position: Int) {
        val book = booksList[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
}