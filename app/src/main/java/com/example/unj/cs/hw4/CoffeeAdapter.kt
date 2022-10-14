package com.example.unj.cs.hw4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoffeeAdapter(private val context: Context, private val coffee: List<Coffee>, val listener: (Coffee) -> Unit)
    : RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>(){

    class CoffeeViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgCoffee = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameCoffee = view.findViewById<TextView>(R.id.tv_item_name)
        val descCoffee = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(coffee: Coffee, listener: (Coffee) -> Unit){
            imgCoffee.setImageResource(coffee.imgCoffee)
            nameCoffee.text = coffee.nameCoffee
            descCoffee.text = coffee.descCoffee
            itemView.setOnClickListener {
                listener(coffee)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return CoffeeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_coffee, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bindView(coffee[position], listener)
    }

    override fun getItemCount(): Int = coffee.size
    }