package com.mbaraka.restaurantpos.ui

import com.mbaraka.restaurantpos.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DrinkAdapter(
    private var drinks: List<DrinkEntity>,
    private val onItemClick: (DrinkEntity) -> Unit
) : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    private var selectedPosition = -1

    class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemRoot: LinearLayout = itemView.findViewById(R.id.itemRoot)
        val tvDrinkName: TextView = itemView.findViewById(R.id.tvDrinkName)
        val tvDrinkPrice: TextView = itemView.findViewById(R.id.tvDrinkPrice)
        val tvSelectTag: TextView = itemView.findViewById(R.id.tvSelectTag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_drink, parent, false)
        return DrinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = drinks[position]
        holder.tvDrinkName.text = "${drink.name}  (Stock: ${drink.stock})"
        holder.tvDrinkPrice.text = "${drink.price} Tsh"

        val context = holder.itemView.context

        if (position == selectedPosition) {
            holder.itemRoot.background =
                ContextCompat.getDrawable(context, R.drawable.bg_drink_item_selected)
            holder.tvSelectTag.text = "Selected"
        } else {
            holder.itemRoot.background =
                ContextCompat.getDrawable(context, R.drawable.bg_drink_item)
            holder.tvSelectTag.text = "Select"
        }

        holder.itemView.setOnClickListener {
            val oldPosition = selectedPosition
            selectedPosition = position
            if (oldPosition != -1) notifyItemChanged(oldPosition)
            notifyItemChanged(selectedPosition)
            onItemClick(drink)
        }
    }

    override fun getItemCount(): Int = drinks.size

    fun updateData(newDrinks: List<DrinkEntity>) {
        drinks = newDrinks
        selectedPosition = -1
        notifyDataSetChanged()
    }
}