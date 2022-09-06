package com.udemy.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.udemy.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionBinding

    private var mCurrentPosition: Int = 1

    private var mQuestionList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question)

        binding.tvFirstOption.setOnClickListener(this)
        binding.tvSecondOption.setOnClickListener(this)
        binding.tvThirdOption.setOnClickListener(this)
        binding.tvFourthOption.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        mQuestionList = Constants.getQuestion()

        getQuestionList()
        defaultOptionView()
    }

    private fun getQuestionList() {
        val question: Question = mQuestionList!![mCurrentPosition - 1]

        binding.ivFlag.setImageResource(question.image)
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text =
            resources.getString(R.string.tv_progress, mCurrentPosition, binding.progressBar.max)
        binding.tvQuestion.text = question.question
        binding.tvFirstOption.text = question.firstOption
        binding.tvSecondOption.text = question.secondOption
        binding.tvThirdOption.text = question.thirdOption
        binding.tvFourthOption.text = question.fourthOption

        if (mCurrentPosition == mQuestionList!!.size) {
            binding.btnSubmit.text = resources.getString(R.string.txt_finish)
        } else {
            binding.btnSubmit.text = resources.getString(R.string.txt_submit)
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()

        binding.tvFirstOption.let {
            options.add(0, it)
        }

        binding.tvSecondOption.let {
            options.add(1, it)
        }

        binding.tvThirdOption.let {
            options.add(2, it)
        }

        binding.tvFourthOption.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_first_option -> {
                selectedOptionView(binding.tvFirstOption, 1)
            }

            R.id.tv_second_option -> {
                selectedOptionView(binding.tvSecondOption, 2)
            }

            R.id.tv_third_option -> {
                selectedOptionView(binding.tvThirdOption, 3)
            }

            R.id.tv_fourth_option -> {
                selectedOptionView(binding.tvFourthOption, 4)
            }

            R.id.btn_submit -> {
                // TODO "implement btn_submit"
            }
        }
    }

}