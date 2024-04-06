package com.example.lab2cats

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2cats.databinding.ItemCatBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide


class CatListAdapter(private val context: Context) :
    ListAdapter<Cat, CatListAdapter.CatViewHolder>(CatDiffCallback) {

    class CatViewHolder(
        val binding: ItemCatBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemCatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = getItem(position)
        with(holder.binding) {
            with(cat) {
                textView.text = "name: $name"
                textView2.text = "length: $length"
                textView3.text= "origin: $origin"
                textView4.text= "Min Weight:"+ minWeight.toString()+" kg"
                textView5.text= "Min life expectancy"+ minLifeExpectancy.toString()+" years"
                Glide.with(context)
                    .load(imageLink)
                    .fitCenter()
                    .into(imageView)

            }

        }
    }

    object CatDiffCallback : DiffUtil.ItemCallback<Cat>() {

        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }
}