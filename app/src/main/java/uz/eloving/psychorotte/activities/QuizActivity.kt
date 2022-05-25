package uz.eloving.psychorotte.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import uz.eloving.psychorotte.Constants
import uz.eloving.psychorotte.QuestionModel
import uz.eloving.psychorotte.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    var isChecking = true
    private lateinit var optionTV: TextView
    var isOptionClicked = false
    var correctAnswers = 0

    var questions = ArrayList<QuestionModel>()
    var questionNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
        questions = Constants.getQuestions()
        questions.shuffle()
        binding.progress.max = questions.size
        updateQuestion()
    }


    @SuppressLint("SetTextI18n")
    fun updateQuestion() {
        if (questionNumber >= questions.size) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("correct", correctAnswers)
            startActivity(intent)
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
