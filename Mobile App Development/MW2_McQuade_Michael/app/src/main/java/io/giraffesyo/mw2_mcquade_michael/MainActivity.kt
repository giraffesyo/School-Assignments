package io.giraffesyo.mw2_mcquade_michael

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert

class MainActivity : AppCompatActivity() {
    // declare a container for our states
    val states: ArrayList<US_State> = ArrayList()
    // create an array of "already seen" flags
    val alreadySeen: BooleanArray = BooleanArray(50)
    // create a score
    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load the array
        addStates()

        // Create a vertical Layout Manager and add it to our recycler view
        rvStates.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // Set the adapter for our recycler view
        rvStates.adapter = StatesRecyclerViewAdapter(states, ::changeScore, this)

        // add divider
        val divider = DividerItemDecoration(rvStates.context, DividerItemDecoration.VERTICAL)
        rvStates.addItemDecoration(divider)


        // set on click listener for our reset button
        tvResetScore.setOnClickListener {
            alert("Are you sure you want to start over?") {
                positiveButton("Yes") { dialog ->
                    resetGame()
                    dialog.dismiss()
                }
                negativeButton("No") { dialog ->
                    dialog.cancel()
                }
            }.show()
        }
    }

    fun resetGame() {
        // remove all points
        changeScore(-score)
        //empty states array
        states.clear()
        // readd them
        addStates()
        //refresh recycler view
        rvStates.adapter?.notifyDataSetChanged()
    }


    fun changeScore(by: Int) {
        // increment (or decrement if by is negative) by the given argument
        this.score += by
        // set the text view to have the score displayed
        tvScore.text = "Score: ${score.toString()}/50"
    }


    fun addStates() {
        val StateNames: Array<String> = resources.getStringArray(R.array.state_names)
        val StateNickNames: Array<String> = resources.getStringArray(R.array.state_nicknames)
        val StateImages: TypedArray = resources.obtainTypedArray(R.array.state_images)
        // we have 50 states so we will do a loop that will execute 50 times to create our array
        for (i in 0..49) {
            // get the current state out of our state.xml file
            val img: Drawable? = StateImages.getDrawable(i)
            val name: String = StateNames[i]
            val nickname: String = StateNickNames[i]
            // create an object with the above values
            var state = US_State(img, name, nickname, false)
            // add the state to our array of states
            states.add(i, state)
        }
        // Clean up our typed array
        StateImages.recycle()
    }

    class US_State(val img: Drawable?, val name: String, val nickname: String, var seen: Boolean)
}
