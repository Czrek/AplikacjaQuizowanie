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

        GenerateQuestionFunction()


    }

    private fun GenerateQuestionFunction() {
        val q1 = Question("2+2", "1", "5", "4", 3)
        addQuestion(q1)
        val q2 = Question("5+6", "4", "2", "11", 3)
        addQuestion(q2)
        val q3 = Question("Rozszerzenie liby Pi do 5 znaku po przecinku"	,"3,14983"	,"3,14159",	"3,15009",	2)
        addQuestion(q3)
        val q4 = Question("45-30+5	","	18	","	21	","	20	",3)
        addQuestion(q4)
        val q5 = Question("(6*3+4)/2","7","12","11", 2)
        addQuestion(q5)
        val q6 = Question("(2*2	","	4	","	8	","	6	",	1	)
        addQuestion(q6)
        val q7 = Question("(2+4)*(5-2)	","	18	","	16	","	20	",	1	)
        addQuestion(q7)
        val q8 = Question("2^7	","	16	","	64	","	128	",	3	)
        addQuestion(q8)
        val q9 = Question("5*3	","	22	","	33	","	15	",3	)
        addQuestion(q9)
        val q10 = Question("4+6/2*4	","	14	","	18	","	16	",	3	)
        addQuestion(q10)
        val q11 = Question("Stolica Polski to.:"	,"	Warszawa	","	Kraków	","	Poznań	",	2	)
        addQuestion(q11)
        val q12 = Question("Stolica Hiszpani to.:	","	Madryt	","	Rzym	","	Barcelona	",	1	)
        addQuestion(q12)
        val q13 = Question("Najwyższy szczyt w Polsce.:	","	Snieżka	","	Rysy	","	Babia góra	",2	)
        addQuestion(q13)
        val q14 = Question("Najwyższy szczyt w Karkonoszach.:	","	Wielki Szyszak	","	Kopa	","	Śnieżka	",	3	)
        addQuestion(q14)
        val q15 = Question("Stolica Niemiec to:	","	Berlin	","	Lipsk	","	Monachium	",	1	)
        addQuestion(q15)
        val q16 = Question("Najwieksze miasto w Polsce to:	","	Kraków	","	Warszawa	","	Wrocław	",	2	)
        addQuestion(q16)
        val q17 = Question("Oddzielaja Europe i Azje?	","	Tatry	","	Góry Ural	","	Alpy	",	2	)
        addQuestion(q17)
        val q18 = Question("Najwiekszy ocean swiata to?	","	Spokojny	","	Indysjki	","	Atlantycki	",	1	)
        addQuestion(q18)
        val q19 = Question("Bitwa pod Grunwaldem odbyła się:	","	1401	","	1410	","	1411	",	2	)
        addQuestion(q19)
        val q20 = Question("Gdzie urodził sie Sobieski:	","	Pod Wiedniem	","	Pod Grunwaldem	","	Nie wiem	",	3	)
        addQuestion(q20)
        val q21 = Question("Która odpowiedź jest poprawna?	","	TA	","	Nie Wiem	","	Na pewno nie ta	",	1	)
        addQuestion(q21)
        val q22 = Question("Która odpowiedź jest poprawna?	","	Nie Wiem	","	TA	","	Na pewno nie ta	",	2	)
        addQuestion(q22)
        val q23 = Question("Która odpowiedź jest poprawna?	","	Na pewno nie ta	","	TA	","	Nie Wiem	",	2	)
        addQuestion(q23)
        val q24 = Question("Która odpowiedź jest poprawna?	","	TA	","	Nie Wiem	","	Na pewno nie ta	",	1	)
        addQuestion(q24)
        val q25= Question("Która odpowiedź jest poprawna?	","	Nie Wiem	","	Na pewno nie ta	","	TA	",	3	)
        addQuestion(q25)
        val q26 = Question("Która odpowiedź jest poprawna?	","	Nie Wiem	","	Na pewno nie ta	","	TA	",	3	)
        addQuestion(q26)





    }



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
