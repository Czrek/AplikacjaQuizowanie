package com.example.quizowanie

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothServerSocket
import android.bluetooth.BluetoothSocket
import android.content.*
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_panel_tworzenia.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class panel_glowny : AppCompatActivity() {

    private var txtHighScore: TextView? = null
    private var mhighscore: Int = 0
    private var allscore: Int = 0






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel_glowny)


        txtHighScore = this.findViewById(R.id.highscore)
        loadHighScore()
        val bt = findViewById<Button>(R.id.BTbutton)
        bt.setOnClickListener {
            startActivityForResult(
                Intent(
                    applicationContext,
                    bluetoothh::class.java
                ), REQUEST_CODE
            )
        }
        val fr = findViewById<Button>(R.id.FIREbutton)
        fr.setOnClickListener {
            startActivityForResult(Intent(applicationContext, Firebasee::class.java), REQUEST_CODE)
        }

        val startQuiz = findViewById<Button>(R.id.pierwszyButton)
        startQuiz.setOnClickListener {
            startActivityForResult(Intent(applicationContext, MainQuiz::class.java), REQUEST_CODE)
        }
        /*  if (allscore > 76) {
            val startQuiz2 = findViewById<Button>(R.id.drugiButton)
            startQuiz2.setOnClickListener {
                startActivityForResult(
                    Intent(applicationContext, DrugiQuiz::class.java),
                    REQUEST_CODE
                )

            }
        } else {
            val startQuiz3 = findViewById<Button>(R.id.drugiButton)
            startQuiz3.setOnClickListener {
                Toast.makeText(
                    this,
                    "Masz za mało punktów żeby otworzyć tą kategorie\n-Potrzeba 70 pkt",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
*/


    }

    override fun onStart() {
        super.onStart()

        if (allscore > 89) {
            val startQuiz2 = findViewById<Button>(R.id.drugiButton)
            startQuiz2.setOnClickListener {
                startActivityForResult(
                    Intent(applicationContext, DrugiQuiz::class.java),
                    REQUEST_CODE
                )

            }
        } else {
            val startQuiz3 = findViewById<Button>(R.id.drugiButton)
            startQuiz3.setOnClickListener {
                Toast.makeText(
                    this,
                    "Masz za mało punktów żeby otworzyć tą kategorie\n-Potrzeba 90 pkt",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        if (allscore > 179) {
            val startQuiz2 = findViewById<Button>(R.id.trzeciButton)
            startQuiz2.setOnClickListener {
                startActivityForResult(
                    Intent(applicationContext, TrzeciQuiz::class.java),
                    REQUEST_CODE
                )

            }
        } else {
            val startQuiz3 = findViewById<Button>(R.id.trzeciButton)
            startQuiz3.setOnClickListener {
                Toast.makeText(this,"Masz za mało punktów żeby otworzyć tą kategorie\n-Potrzeba 180 pkt",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val score = data!!.getIntExtra(MainQuiz.FINAL_SCORE, 0)
                allscore = score + allscore
                txtHighScore!!.text = "Wszystkie punkty:- $allscore"
                val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putInt(HIGH_SCORE, allscore)
                editor.apply()
                    //   if (score > mhighscore) {
                 //   updateScore(score)
               // }
            }
        }

    }

   /* private fun updateScore(score: Int) {
        mhighscore = score
        txtHighScore!!.text = "My High Score:- $mhighscore"

        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt(HIGH_SCORE, mhighscore)
        editor.apply()

        }
*/

    private fun loadHighScore() {
        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        allscore = preferences.getInt(HIGH_SCORE, 0)
        txtHighScore!!.text = "Punkty:- $allscore"
    }
   // private fun loadHighScore() {
   //     val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    //    mhighscore = preferences.getInt(HIGH_SCORE, 0)
   //     txtHighScore!!.text = "My High Score:- $mhighscore"

  //  }
    companion object {

        private val REQUEST_CODE = 1
        val PREFS = "shared_prefs"
        val HIGH_SCORE = "high_score"
    }








}
