package com.udemy.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udemy.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question)
        getQuestionList()
    }

    private fun getQuestionList() {
        val questionList = Constants.getQuestion()
        Log.i("question list size is", "${questionList.size}")

        for (i in questionList) {
            Log.e("Questions", i.question)
        }

        val currentPosition = 1
        val question: Question = questionList[currentPosition - 1]

        binding.ivFlag.setImageResource(question.image)
        binding.progressBar.progress = currentPosition
        binding.tvProgress.text =
            resources.getString(R.string.tv_progress, currentPosition, binding.progressBar.max)
        binding.tvQuestion.text = question.question
        binding.tvFirstOption.text = question.firstOption
        binding.tvSecondOption.text = question.secondOption
        binding.tvThirdOption.text = question.thirdOption
        binding.tvFourthOption.text = question.fourthOption
    }

}