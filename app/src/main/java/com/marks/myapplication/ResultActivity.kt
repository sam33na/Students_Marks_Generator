package com.marks.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var firstPosition: TextView
    private lateinit var secondPosition: TextView
    private lateinit var thirdPosition: TextView
    private lateinit var subjHighest: TextView
    private lateinit var subjSecondHighest: TextView
    private lateinit var subjThirdHighest: TextView

    private var studentList: List<Student> = ArrayList()
    private var positionalMap = mutableMapOf<String, Double>()
    private var subjMarksMap = mutableMapOf<String, Double>()

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        firstPosition = findViewById(R.id.tvFirstPosition)
        secondPosition = findViewById(R.id.tvSecondPosition)
        thirdPosition = findViewById(R.id.tvThirdPosition)
        subjHighest = findViewById(R.id.tvHighest)
        subjSecondHighest = findViewById(R.id.tvSecondHighest)
        subjThirdHighest = findViewById(R.id.tvThirdHighest)

        val resultIntent = intent
        if (resultIntent != null){
            studentList = resultIntent.getSerializableExtra("studentList") as List<Student>
        }

        val index = studentList.size - 1

        //setting texts for positional rankings
        firstPosition.text = "1st: ${getNameInPositionRank(index).capitalize()} | " +
                "${positionRanking()[getNameInPositionRank(index)]}"

        secondPosition.text = "2nd: ${getNameInPositionRank(index - 1).capitalize()} | " +
                "${positionRanking()[getNameInPositionRank(index- 1)]}"

        thirdPosition.text = "3rd: ${getNameInPositionRank(index - 2).capitalize()} | " +
                "${positionRanking()[getNameInPositionRank(index - 2)]}"

        //setting texts for subject rankings
        subjHighest.text = "Highest: ${getNameInSubjectRank(index).capitalize()} | " +
                "${subjectRanking()[getNameInSubjectRank(index)]}"

        subjSecondHighest.text = "2nd Highest: ${getNameInSubjectRank(index - 1).capitalize()} | " +
                "${subjectRanking()[getNameInSubjectRank(index - 1)]}"

        subjThirdHighest.text = "3rd Highest: ${getNameInSubjectRank(index - 2).capitalize()} | " +
                "${subjectRanking()[getNameInSubjectRank(index - 2)]}"
    }


    private fun positionRanking(): Map<String, Double>{

        for (i in studentList.indices){
            positionalMap[studentList[i].name] = studentList[i].percentageObtained()
        }

        return positionalMap.toList()
                .sortedBy { (_, value) -> value }
                .toMap()
    }

    private fun subjectRanking(): Map<String, Double>{
        for (i in studentList.indices){
            subjMarksMap[studentList[i].name] = studentList[i].markAndroid
        }
        return subjMarksMap.toList()
                .sortedBy { (_, value) -> value }
                .toMap()
    }


    private fun getNameInPositionRank(index: Int): String{
        return positionRanking().toList()[index].toString().split(",")[0].drop(1)
    }

    private fun getNameInSubjectRank(index: Int): String{
        return subjectRanking().toList()[index].toString().split(",")[0].drop(1)
    }
}








