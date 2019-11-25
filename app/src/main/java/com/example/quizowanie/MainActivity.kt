package com.example.quizowanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(applicationContext, panel_glowny::class.java))




        val panelQuiz = findViewById<Button>(R.id.logowanieBT)
        panelQuiz.setOnClickListener {
            startActivity(Intent(applicationContext, panel_glowny::class.java))
        }
    }


}
