package com.example.libraryview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

const val SUBJECT_EXTRA = "SUBJECT_EXTRA"
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var subject = ""

    lateinit var fantasyBtn: Button
//    lateinit var nonfictionBtn: Button
//    lateinit var classicsBtn: Button
    lateinit var comicsBtn: Button
    lateinit var essayBtn: Button
    lateinit var romanceBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fantasyBtn = findViewById(R.id.fantasyBtn)
//        nonfictionBtn = findViewById(R.id.nonfictionBtn)
//        classicsBtn = findViewById(R.id.classicsBtn)
        comicsBtn = findViewById(R.id.comicsBtn)
        essayBtn = findViewById(R.id.essayBtn)
        romanceBtn = findViewById(R.id.romanceBtn)


        fantasyBtn.setOnClickListener {
            subject = "fantasy"
            gotoSubjectPage()
        }
//        nonfictionBtn.setOnClickListener {
//            subject = "nonfiction"
//            gotoSubjectPage()
//        }
//        classicsBtn.setOnClickListener {
//            subject = "classics"
//            gotoSubjectPage()
//        }
        comicsBtn.setOnClickListener {
            subject = "comic"
            gotoSubjectPage()
        }
        essayBtn.setOnClickListener {
            subject = "essay"
            gotoSubjectPage()
        }
        romanceBtn.setOnClickListener {
            subject = "romance"
            gotoSubjectPage()
        }
    }

    private fun gotoSubjectPage() {
        val subjectPageIntent = Intent(this, SubjectPage::class.java)
        subjectPageIntent.putExtra(SUBJECT_EXTRA, subject)
        Log.d(TAG, "Going to $subject page.")
        this.startActivity(subjectPageIntent)
    }

}