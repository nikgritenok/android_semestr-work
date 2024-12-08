package com.example.semestrwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DogAdapter(private var dogList: List<Dog>) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewDog: ImageView = itemView.findViewById(R.id.imageViewDog)
        //val textViewBreed: TextView = itemView.findViewById(R.id.textViewBreed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = dogList[position]
        Glide.with(holder.itemView.context)
            .load(dog.url)
            .into(holder.imageViewDog)

//        holder.textViewBreed.text = if (dog.breeds.isNotEmpty()) {
//            dog.breeds[0].name
//        } else {
//            "Неизвестная порода"
//        }
    }

    fun updateData(list: List<Dog>) {
        dogList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dogList.size
}