package io.giraffesyo.w10_mcquade_michael

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import Cash

class MainActivity : AppCompatActivity() {
    // For use in our Log calls
    private val TAG = "MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create 6 Cash Objects
        val Money1 = Cash(-1.00)
        val Money2 = Cash(0.00)
        val Money3 = Cash(54.25)
        val Money4 = Cash(4.16)
        val Money5 = Cash(99.99)
        val Money6 = Cash(47.23)

        // Log out string representations
        Log.d(TAG, "1: " + Money1.toString())
        Log.d(TAG, "2: " + Money2.toString())
        Log.d(TAG, "3: " + Money3.toString())
        Log.d(TAG, "4: " + Money4.toString())
        Log.d(TAG, "5: " + Money5.toString())
        Log.d(TAG, "6: " + Money6.toString())

    }

}
