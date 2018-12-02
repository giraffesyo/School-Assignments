package io.giraffesyo.mw2_mcquade_michael

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class StatesRecyclerViewAdapter(val items: ArrayList<String>, val context: Context): RecyclerView.Adapter<StatesRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_row, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    // p0 will be each cell, p1 is the index
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        // Set the state name in the current cell's (p0) view holder
        // the text is coming from items.get(p1), which returns the item at index p1
        p0?.tvStateName?.text = items.get(p1)
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // Assign a reference to the text view which will hold the state name
        val  tvStateName = view.tvStateName
    }
}

