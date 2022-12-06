package com.softaai.simpplr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv: TextView = findViewById(R.id.tv)

        val maxSeqSize = getMaxSeqSize("12345")
        println("maxSeqSize = " + maxSeqSize)
        tv.text = "maxSeqSize = $maxSeqSize"
    }

    //1,2,3,4,5 --> 5
//1,2,4,3,4,5 --> 3

    //1 -> 1

    //1,2,4,3,4,5 --> 3

    // soFar = 2, here =  3
    fun getMaxSeqSize(input: String): Int {
        var maxSeqSizeSoFar = 0
        var maxSeqSizeHere = 0
        for (i in 0..input.length-2) {

            var  next  = input[i+1]
            var  current  = input[i]
            if (next - current > 1) {
                maxSeqSizeHere = 0
            }
            // 2 < 3
//            else if (maxSeqSizeSoFar < maxSeqSizeHere) {
//                maxSeqSizeSoFar = maxSeqSizeHere   // maxSeqSizeSoFar = 3
//            }
            maxSeqSizeSoFar = maxSeqSizeHere
            maxSeqSizeHere++

        }


        return maxSeqSizeSoFar
    }
}