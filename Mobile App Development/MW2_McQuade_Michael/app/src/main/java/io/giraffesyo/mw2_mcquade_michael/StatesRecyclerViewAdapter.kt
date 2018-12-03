package io.giraffesyo.mw2_mcquade_michael

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import org.jetbrains.anko.*

class StatesRecyclerViewAdapter(val items: ArrayList<MainActivity.US_State>, val changeScore: (by: Int) -> Unit, val context: Context) :
    RecyclerView.Adapter<StatesRecyclerViewAdapter.ViewHolder>(), AnkoLogger {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_row, p0, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)

        if(items[position].seen){
            // if seen we should have a customized pastel background color
            holder.llStateRow.backgroundColor = this.context.resources.getColor(R.color.colorAlreadySeen)
        } else {
            // if not seen we should have a white background
            holder.llStateRow.setBackgroundColor(Color.TRANSPARENT)
        }

        // handle click events by adding a listener to the view
        holder.itemView.setOnClickListener{

            info("clicked $position")
            if(!items[position].seen){
                // the user hadn't seen this state until now, so we need to mark it and increase the score!
                holder.llStateRow.backgroundColor = this.context.resources.getColor(R.color.colorAlreadySeen)
                items[position].seen = true
                // increment the score by 1
                changeScore(1)
            }
        }
    }



   /* // called when cell is clicked
    override fun onClick(v: View?) {
        info("clicked")

        /*

        val test
            info("Clicked on")
            // if we have haven't already seen the state, increment the score and change hte background color
            if (!viewHolder.alreadySeen) {
                viewHolder.llStateRow.backgroundColor = this.context.resources.getColor(R.color.colorAlreadySeen)
            } else {
                //otherwise, we have seen the state, ask the user if we want to remove the state
                //viewHolder.alreadySeen
            }
         */
    }*/

    override fun getItemCount(): Int {
        return items.size
    }

    // p0 will be each cell, p1 is the index
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        // Set the state name in the current cell's (p0) view holder
        // the text is coming from items.get(p1), which returns the item at index p1
        p0.tvStateName.text = items.get(p1).name
        p0.tvStateCaption.text = items.get(p1).nickname
        p0.ivStateImage.image = items.get(p1).img
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Assign a reference to the text view which will hold the state name
        val tvStateName: TextView = view.tvStateName
        val ivStateImage: ImageView = view.ivStateImage
        val tvStateCaption: TextView = view.tvStateCaption
        val llStateRow: LinearLayout = view.llStateRow
    }
}

