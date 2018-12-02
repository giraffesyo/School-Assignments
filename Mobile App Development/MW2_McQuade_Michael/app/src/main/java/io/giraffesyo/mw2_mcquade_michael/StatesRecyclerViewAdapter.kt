package io.giraffesyo.mw2_mcquade_michael

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class StatesRecyclerViewAdapter(val items: ArrayList<String>, val context: Context): RecyclerView.Adapter<StatesRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        // Assign a reference to the text view which will hold the state name
        val  tvStateName = view.tvStateName


    }
}

