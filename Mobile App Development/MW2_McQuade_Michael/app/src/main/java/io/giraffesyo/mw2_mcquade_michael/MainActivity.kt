package io.giraffesyo.mw2_mcquade_michael

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val states: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load the array
        addStates()

        // Create a vertical Layout Manager and add it to our recycler view
        rvStates.layoutManager = LinearLayoutManager(this)

        // Set the adapter for our recycler view
        rvStates.adapter = StatesRecyclerViewAdapter(states, this)
    }

    fun addStates() {
        for(i in 1..8) {
            states.add("aardvark $i")
        }
    }
}
