package com.marks.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var first: TextView
    private lateinit var second: TextView
    private lateinit var third: TextView
    private lateinit var stdFirst: TextView
    private lateinit var stdSecond: TextView
    private lateinit var stdThird: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        first=findViewById(R.id.first)
        second=findViewById(R.id.second)
        third=findViewById(R.id.third)
        stdFirst=findViewById(R.id.stdFirst)
        stdSecond=findViewById(R.id.stdSecond)
        stdThird=findViewById(R.id.stdThird)
    }
}