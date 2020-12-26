package com.marks.myapplication

import java.io.Serializable

class Student(val id: Int, val name: String, val markAndroid: Double,
              val markAPI: Double, val markIOT: Double): Serializable{
//    constructor(): this(3, "s", 50.3, 50.2, 50.5)

    fun percentageObtained(): Double{
        return String.format("%.3f", (markAndroid + markAPI + markIOT) / 3).toDouble()
    }
}
