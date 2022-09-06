package com.udemy.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udemy.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        buttonStart()
    }

    private fun buttonStart() {
        binding.btnStart.setOnClickListener {
            if (binding.etName.text?.isEmpty()!!) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.txt_enter_name),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}