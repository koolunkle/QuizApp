package com.udemy.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udemy.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        setResult()
    }

    private fun setResult() {
        binding.tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)

        binding.tvScore.text =
            resources.getString(R.string.txt_score).format(correctAnswer, totalQuestions)

        binding.btnResult.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}