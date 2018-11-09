package io.giraffesyo.w11_mcquade_michael

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var Sum: Int = 0
    var Operations: MutableList<Int> = mutableListOf<Int>(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // called by all of the numeric buttons, increments the sum
    fun addPoints(view: View) {
        // cast view to button
        var button = view as Button
        // cast char sequence to string then to number
        val value = button.text.toString().toInt(10)
        changeValue(value)
    }

    // Directly modifies the sum by given number, adds the change to the operations list
    fun changeValue(by: Int) {
        this.Sum += by
        this.Operations.add(by)
        tvSum.text = this.Sum.toString()
    }
    // recalculates the sum based off the entire list of operations
    fun recalculateSum() {
        this.Sum = this.Operations.reduce { acc, value -> acc + value }
        tvSum.text = this.Sum.toString()
    }

    // resets the sum to 0
    fun clearPoints(view: View) {
        // Create a new list with only 0 in it and point Operations at it, then recalcualte the view
        Operations = mutableListOf(0)
        recalculateSum()
    }
    // undoes the last operation
    fun undo(view: View) {
        // Only perform undo if we have more than one item in our list
        if (this.Operations.lastIndex != 0) {
            val removedVal = this.Operations.removeAt(this.Operations.lastIndex)
            this.Sum = this.Sum - removedVal
            recalculateSum()
        }

    }


}
