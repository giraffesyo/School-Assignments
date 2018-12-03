package io.giraffesyo.mw2_mcquade_michael

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // declare a container for our states
    val states: ArrayList<Triple<Drawable?,String, String>> = ArrayList()

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
        val StateNames: Array<String> = resources.getStringArray(R.array.state_names)
        val StateNickNames: Array<String> = resources.getStringArray(R.array.state_nicknames)
        val StateImages: TypedArray =  resources.obtainTypedArray(R.array.state_images)
        // we have 50 states so we will do a loop that will execute 50 times to create our array
        for (i in 0..49){
            // get the current state out of our state.xml file
            val img: Drawable? = StateImages.getDrawable(i)
            val name: String = StateNames[i]
            val nickname: String = StateNickNames[i]
            // create a triplet with the above values
            var state = Triple(img, name, nickname )
            // add the state to our array of triplets
            states.add(i, state)
        }
        // Clean up our typed array
        StateImages.recycle()
    }
}
