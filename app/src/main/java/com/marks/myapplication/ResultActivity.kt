package com.marks.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.marks.Student

class ResultActivity : AppCompatActivity() {
    private lateinit var first: TextView
    private lateinit var second: TextView
    private lateinit var third: TextView
    private lateinit var subTop: TextView
    private lateinit var subMid: TextView
    private lateinit var subLow: TextView


    private var studentList: List<Student> = ArrayList()
    private var positionalMap = mutableMapOf<String, Double>()
    private var subjectMap = mutableMapOf<String, Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        first=findViewById(R.id.first)
        second=findViewById(R.id.second)
        third=findViewById(R.id.third)
        subTop=findViewById(R.id.stdFirst)
        subMid=findViewById(R.id.stdSecond)
        subLow=findViewById(R.id.stdThird)

        val resultIntent = intent
        if (resultIntent != null){
            studentList = resultIntent.getSerializableExtra("studentList") as List<Student>
        }

        val index=studentList.size-1
        //setting text for ranking
        first.text="1st: $(getNameInPositionRank(index).capitalize()} ! "+
                "${rankPosition()[getNameInPositionRank(index)]}"
        second.text="1st: $(getNameInPositionRank(index-1).capitalize()} ! "+
                "${rankPosition()[getNameInPositionRank(index-1)]}"
        third.text="1st: $(getNameInPositionRank(index-2).capitalize()} ! "+
                "${rankPosition()[getNameInPositionRank(index-2)]}"
        //setting text for subject
        subTop.text = "Highest: ${getNameInSubjectRank(index).capitalize()} | " +
                "${subjectRank()[getNameInSubjectRank(index)]}"

        subMid.text = "2nd Highest: ${getNameInSubjectRank(index - 1).capitalize()} | " +
                "${subjectRank()[getNameInSubjectRank(index - 1)]}"

        subLow.text = "3rd Highest: ${getNameInSubjectRank(index - 2).capitalize()} | " +
                "${subjectRank()[getNameInSubjectRank(index - 2)]}"
    }
    //map function for positioning ranks and subject marks
    private fun rankPosition():Map<String,Double>
    {
        //creating a map w/ name as key and percentage as value
        for(i in studentList.indices)
        {
            positionalMap[studentList[i].name]=studentList[i].percentageObtained()
        }
        //sorting array in ascending
        return  positionalMap.toList()
                .sortedBy { (key,value)->value }.toMap()
    }
    private fun subjectRank():Map<String,Double>
    {
        //creating a map w/ name as key and percentage as value
        for(i in studentList.indices)
        {
            subjectMap[studentList[i].name]=studentList[i].markAndroid
        }
        //sorting array in ascending
        return  subjectMap.toList()
                .sortedBy { (key,value)->value }.toMap()
    }
    //getting the 'name' i.e. key from the map
    private fun getNameInPositionRank(index: Int): String{
        return rankPosition().toList()[index].toString().split(",")[0].drop(1)
    }
    private fun getNameInSubjectRank(index: Int): String{
        return subjectRank().toList()[index].toString().split(",")[0].drop(1)
    }


}