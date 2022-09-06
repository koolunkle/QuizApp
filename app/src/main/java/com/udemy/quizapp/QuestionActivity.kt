package com.udemy.quizapp

import android.content.Intent
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

    private var mUserName: String? = null

    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

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
        defaultOptionView()

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
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            getQuestionList()
                        }

                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        binding.btnSubmit.text = resources.getString(R.string.txt_finish)
                    } else {
                        binding.btnSubmit.text = resources.getString(R.string.txt_next_question)
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvFirstOption.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                binding.tvSecondOption.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                binding.tvThirdOption.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                binding.tvFourthOption.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

}