package io.giraffesyo.mw2_mcquade_michael

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.image
import org.jetbrains.anko.info

class StatesRecyclerViewAdapter(val items: ArrayList<Triple<Drawable?, String, String>>, val context: Context): RecyclerView.Adapter<StatesRecyclerViewAdapter.ViewHolder>(), AnkoLogger {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val viewHolder =  ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_row, p0, false))
        info("test")
        info(viewHolder.itemView.id)
        viewHolder.itemView.setOnClickListener{
            info("Clicked on cell $p1")
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }
    // p0 will be each cell, p1 is the index
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        // Set the state name in the current cell's (p0) view holder
        // the text is coming from items.get(p1), which returns the item at index p1
        p0.tvStateName?.text = items.get(p1).second
        p0.tvStateCaption?.text = items.get(p1).third
        p0.ivStateImage?.image = items.get(p1).first
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // Assign a reference to the text view which will hold the state name
        val tvStateName = view.tvStateName
        val ivStateImage = view.ivStateImage
        val tvStateCaption = view.tvStateCaption
    }
}

