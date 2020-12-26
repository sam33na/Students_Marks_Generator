package com.marks.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.marks.Student

class StudentsMarknActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var stdId:EditText
    private lateinit var stdName:EditText
    private lateinit var androidM:EditText
    private lateinit var apiM:EditText
    private lateinit var iotM:EditText
    private lateinit var studentAdd:EditText

    //creating list for storing students data
    private lateinit var studentList:MutableList<Student>
    private lateinit var student:Student
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

        stdId=findViewById(R.id.stdId)
        stdName=findViewById(R.id.stdName)
        androidM=findViewById(R.id.androidMark)
        apiM=findViewById(R.id.apiMark)
        iotM=findViewById(R.id.iotMark)
        studentAdd=findViewById(R.id.btnList)

        studentList=ArrayList()
        studentAdd.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        //assigning an instance of class 'Student' to variable 'student' i.e. creating object
        student = Student(stdId.text.toString().toInt(), stdName.text.toString(),
                androidM.text.toString().toDouble(), apiM.text.toString().toDouble(),
                iotM.text.toString().toDouble())
//            student = Student()
        studentList.add(student)    //adding the most recent 'student' object to list

        //altering the button text
        if (studentList.size == 2){
            studentAdd.text = "Add and Show All"
        }
        //opening another activity once the list size reaches 3
        else if (studentList.size == 3){
            val displayResultIntent = Intent(this, ResultActivity::class.java).also {
                it.putExtra("studentList", studentList as Serializable?)    //passing list of object
            }
            startActivity(displayResultIntent)
            //assigning the button with its actual text and clearing the values in list
            studentAdd.text = getString(R.string.student_Add)
            studentList.clear()
        }
        //clearing all the editText for each button click
        clearAll()
    }

private fun clearAll(){
    stdId.setText("")
    stdName.setText("")
    androidM.setText("")
    apiM.setText("")
    iotM.setText("")
    stdId.requestFocus()
}
}