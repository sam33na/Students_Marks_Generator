package com.marks.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.Serializable

class StudentsMarkActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var id: EditText
    private lateinit var name: EditText
    private lateinit var androidMark: EditText
    private lateinit var apiMark: EditText
    private lateinit var iotMark: EditText
    private lateinit var addStudent: Button


    private lateinit var student: Student
    private lateinit var studentList: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

        id = findViewById(R.id.etId)
        name = findViewById(R.id.etName)
        androidMark = findViewById(R.id.etAndroidMarks)
        apiMark = findViewById(R.id.etApiMarks)
        iotMark = findViewById(R.id.etIotMarks)
        addStudent = findViewById(R.id.btnAdd)

        studentList = ArrayList()

        addStudent.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        if (v?.id == addStudent.id){

            student = Student(id.text.toString().toInt(), name.text.toString(),
                    androidMark.text.toString().toDouble(), apiMark.text.toString().toDouble(),
                    iotMark.text.toString().toDouble())
//            student = Student()
            studentList.add(student)


            //altering the button text
            if (studentList.size == 2){
                addStudent.text = "Show Result"
            }

            else if (studentList.size == 3){
                val displayResultIntent = Intent(this, ResultActivity::class.java).also {
                    it.putExtra("studentList", studentList as Serializable?)
                }
                startActivity(displayResultIntent)

                addStudent.text="add student"
                studentList.clear()
            }

            clearAll()
        }
    }

    private fun clearAll(){
        id.setText("")
        name.setText("")
        androidMark.setText("")
        apiMark.setText("")
        iotMark.setText("")
        id.requestFocus()
    }
}


