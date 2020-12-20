package com.marks.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class StudentsMarknActivity : AppCompatActivity() {
    private lateinit var stdId:EditText
    private lateinit var stdName:EditText
    private lateinit var androd:EditText
    private lateinit var api:EditText
    private lateinit var iot:EditText
    private lateinit var btn:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

        stdId=findViewById(R.id.stdId)
        stdName=findViewById(R.id.stdName)
        androd=findViewById(R.id.androidMark)
        api=findViewById(R.id.apiMark)
        iot=findViewById(R.id.iotMark)
        btn=findViewById(R.id.btnList)
    }
}