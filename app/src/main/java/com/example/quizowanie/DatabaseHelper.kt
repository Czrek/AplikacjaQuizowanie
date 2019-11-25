package com.example.quizowanie

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.provider.BaseColumns._ID

import java.util.ArrayList

import com.example.quizowanie.QuizContainer.QuizTable.Companion.ANS_COLUMN
import com.example.quizowanie.QuizContainer.QuizTable.Companion.OPTION1_COLUMN
import com.example.quizowanie.QuizContainer.QuizTable.Companion.OPTION2_COLUMN
import com.example.quizowanie.QuizContainer.QuizTable.Companion.OPTION3_COLUMN
import com.example.quizowanie.QuizContainer.QuizTable.Companion.QUESTION_COLUMN
import com.example.quizowanie.QuizContainer.QuizTable.Companion.QUESTION_TABLE_NAME as QUESTION_TABLE_NAME


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private var db: SQLiteDatabase? = null

    val questionSet: List<Question>
        get() {

            val questionSetsList = ArrayList<Question>()

            db = writableDatabase



            val c = db!!.rawQuery("SELECT * FROM $QUESTION_TABLE_NAME WHERE $_ID <11", null)

            if (c.moveToFirst()) {
                do {
                    val question = Question()
                    question.setmQuestion(c.getString(c.getColumnIndex(QUESTION_COLUMN)))
                    question.setmOption1(c.getString(c.getColumnIndex(OPTION1_COLUMN)))
                    question.setmOption2(c.getString(c.getColumnIndex(OPTION2_COLUMN)))
                    question.setmOption3(c.getString(c.getColumnIndex(OPTION3_COLUMN)))
                    question.setmRightAns(c.getInt(c.getColumnIndex(ANS_COLUMN)))
                    questionSetsList.add(question)
                } while (c.moveToNext())

            }
            c.close()
            return questionSetsList
        }


    val questionSet2: List<Question>
        get() {

            val questionSetsList2 = ArrayList<Question>()

            db = writableDatabase



            val c = db!!.rawQuery("SELECT * FROM $QUESTION_TABLE_NAME WHERE $_ID >10 AND $_ID <21", null)

            if (c.moveToFirst()) {
                do {
                    val question = Question()
                    question.setmQuestion(c.getString(c.getColumnIndex(QUESTION_COLUMN)))
                    question.setmOption1(c.getString(c.getColumnIndex(OPTION1_COLUMN)))
                    question.setmOption2(c.getString(c.getColumnIndex(OPTION2_COLUMN)))
                    question.setmOption3(c.getString(c.getColumnIndex(OPTION3_COLUMN)))
                    question.setmRightAns(c.getInt(c.getColumnIndex(ANS_COLUMN)))
                    questionSetsList2.add(question)
                } while (c.moveToNext())

            }
            c.close()
            return questionSetsList2
        }


    val questionSet3: List<Question>
        get() {

            val questionSetsList3 = ArrayList<Question>()

            db = writableDatabase



            val c = db!!.rawQuery("SELECT * FROM $QUESTION_TABLE_NAME WHERE $_ID >20 AND $_ID <31", null)

            if (c.moveToFirst()) {
                do {
                    val question = Question()
                    question.setmQuestion(c.getString(c.getColumnIndex(QUESTION_COLUMN)))
                    question.setmOption1(c.getString(c.getColumnIndex(OPTION1_COLUMN)))
                    question.setmOption2(c.getString(c.getColumnIndex(OPTION2_COLUMN)))
                    question.setmOption3(c.getString(c.getColumnIndex(OPTION3_COLUMN)))
                    question.setmRightAns(c.getInt(c.getColumnIndex(ANS_COLUMN)))
                    questionSetsList3.add(question)
                } while (c.moveToNext())

            }
            c.close()
            return questionSetsList3
        }

    override fun onCreate(db: SQLiteDatabase) {
        this.db = db

        val QB_TABLE = "CREATE TABLE " +
                QUESTION_TABLE_NAME + " ( " +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QUESTION_COLUMN + " TEXT, " +
                OPTION1_COLUMN + " TEXT, " +
                OPTION2_COLUMN + " TEXT, " +
                OPTION3_COLUMN + " TEXT, " +
                ANS_COLUMN + " INTEGER " +
                " )"

        db.execSQL(QB_TABLE)

   //     GenerateQuestionFunction()


    }

 /*   private fun GenerateQuestionFunction() {
        val q1 = Question("2+2", "1", "5", "4", 3)
        addQuestion(q1)
        val q2 = Question("5+6", "4", "2", "11", 3)
        addQuestion(q2)
        val q3 = Question("1+2", "4", "5", "3", 3)
        addQuestion(q3)
        val q4 = Question("5+4", "9", "7", "5", 1)
        addQuestion(q4)
        val q5 = Question("(6*3+4)/2","7","12","11", 2)
        addQuestion(q5)

    }
*/


    private fun addQuestion(qb: Question) {
        val contentValues = ContentValues()
        contentValues.put(QUESTION_COLUMN, qb.getmQuestion())
        contentValues.put(OPTION1_COLUMN, qb.getmOption1())
        contentValues.put(OPTION2_COLUMN, qb.getmOption2())
        contentValues.put(OPTION3_COLUMN, qb.getmOption3())
        contentValues.put(ANS_COLUMN, qb.getmRightAns())
        db!!.insert(QUESTION_TABLE_NAME,null, contentValues)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $QUESTION_TABLE_NAME")
        onCreate(db!!)
    }

    companion object {

        private val DATABASE_NAME = "QuizApp.db"
        private val DATABASE_VERSION = 1
    }

}