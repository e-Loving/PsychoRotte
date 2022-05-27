package uz.eloving.psychorotte.activities

import android.R.color.white
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.eloving.psychorotte.Constants
import uz.eloving.psychorotte.QuestionModel
import uz.eloving.psychorotte.R
import uz.eloving.psychorotte.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private var choice = ""
    private var correctAnswers = 0
    private var questions = ArrayList<QuestionModel>()
    private var questionNumber = 0
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.variant1.setOnClickListener {
            if(choice=="${binding.variant1.text}${questionNumber}"){
                if(binding.variant1.text.toString()==questions[questionNumber].answer){
                    correctAnswers++
                }
                questionNumber++
                updateQuestion()
            }else {
                choice="${binding.variant1.text}${questionNumber}"
                resetTextColor()
                binding.variant1.alpha = 1F
            }
        }
        binding.variant2.setOnClickListener {
            if(choice=="${binding.variant2.text}${questionNumber}"){
                if(binding.variant2.text.toString()==questions[questionNumber].answer){
                    correctAnswers++
                }
                questionNumber++
                updateQuestion()
            }else {
                choice="${binding.variant2.text}${questionNumber}"
                resetTextColor()
                binding.variant2.alpha = 1F
            }

        }
        binding.variant3.setOnClickListener {
            if(choice=="${binding.variant3.text}${questionNumber}"){
                if(binding.variant3.text.toString()==questions[questionNumber].answer){
                    correctAnswers++
                }
                questionNumber++
                updateQuestion()
            }else {
                choice="${binding.variant3.text}${questionNumber}"
                resetTextColor()
                binding.variant3.alpha = 1F
            }

        }
        binding.variant4.setOnClickListener {
            if(choice=="${binding.variant4.text}${questionNumber}"){
                if(binding.variant4.text.toString()==questions[questionNumber].answer){
                    correctAnswers++
                }
                questionNumber++
                updateQuestion()
            }else {
                choice="${binding.variant4.text}${questionNumber}"
                resetTextColor()
                binding.variant4.alpha = 1F
            }

        }

        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
        questions = Constants.getQuestions()
        questions.shuffle()
        binding.progress.max = questions.size
        updateQuestion()


    }

    @SuppressLint("ResourceAsColor")
    private fun resetTextColor() {
        binding.variant1.alpha = 0.5F
        binding.variant2.alpha = 0.5F
        binding.variant3.alpha = 0.5F
        binding.variant4.alpha = 0.5F
    }


    @SuppressLint("SetTextI18n")
    fun updateQuestion() {
        binding.variant1.alpha = 1F
        binding.variant2.alpha = 1F
        binding.variant3.alpha = 1F
        binding.variant4.alpha = 1F
        if (questionNumber >= questions.size) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("correct", correctAnswers)
            startActivity(intent)
            finish()
            return
        }
        binding.progress.progress = questionNumber + 1
        binding.tvQuestionNumber.text = "${questionNumber + 1}/${questions.size}"
        binding.tvSavol.text = questions[questionNumber].savol

        val options = arrayOf(
            questions[questionNumber].variant1,
            questions[questionNumber].variant2,
            questions[questionNumber].variant3,
            questions[questionNumber].variant4
        )
        options.shuffle()



        binding.variant1.text = options[0]
        binding.variant2.text = options[1]
        binding.variant3.text = options[2]
        binding.variant4.text = options[3]
    }

}
