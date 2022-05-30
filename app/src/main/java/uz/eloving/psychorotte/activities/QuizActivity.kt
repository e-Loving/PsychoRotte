package uz.eloving.psychorotte.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import uz.eloving.psychorotte.Constants
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.QuestionModel
import uz.eloving.psychorotte.R
import uz.eloving.psychorotte.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private var choice = ""
    private var correctAnswers = 0
    private var questions = ArrayList<QuestionModel>()
    private var questionNumber = 0
    private var wrongAnswers = 0

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.variant1.setOnClickListener {
            if (choice == "${binding.variant1.text}${questionNumber}") {
                if (binding.variant1.text.toString() == questions[questionNumber].answer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                    binding.variant1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.red)
                }
                setBackground()
                questionNumber++
            } else {
                choice = "${binding.variant1.text}${questionNumber}"
                resetBackgroundColor()
                binding.variant1.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
            }
        }
        binding.variant2.setOnClickListener {
            if (choice == "${binding.variant2.text}${questionNumber}") {
                if (binding.variant2.text.toString() == questions[questionNumber].answer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                    binding.variant2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.red)
                }
                setBackground()
                questionNumber++
            } else {
                choice = "${binding.variant2.text}${questionNumber}"
                resetBackgroundColor()
                binding.variant2.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
            }

        }
        binding.variant3.setOnClickListener {
            if (choice == "${binding.variant3.text}${questionNumber}") {
                if (binding.variant3.text.toString() == questions[questionNumber].answer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                    binding.variant3.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.red)
                }
                setBackground()
                questionNumber++
            } else {
                choice = "${binding.variant3.text}${questionNumber}"
                resetBackgroundColor()
                binding.variant3.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
            }

        }
        binding.variant4.setOnClickListener {
            if (choice == "${binding.variant4.text}${questionNumber}") {
                if (binding.variant4.text.toString() == questions[questionNumber].answer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                    binding.variant4.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.red)
                }
                setBackground()
                questionNumber++
            } else {
                choice = "${binding.variant4.text}${questionNumber}"
                resetBackgroundColor()
                binding.variant4.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
            }

        }

        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
        questions = Constants.islomga_davat()
        questions.shuffle()
        binding.progress.max = questions.size
        updateQuestion()
    }

    @SuppressLint("ResourceAsColor")
    private fun resetBackgroundColor() {
        binding.variant1.backgroundTintList = ContextCompat.getColorStateList(this, R.color.blue)
        binding.variant2.backgroundTintList = ContextCompat.getColorStateList(this, R.color.blue)
        binding.variant3.backgroundTintList = ContextCompat.getColorStateList(this, R.color.blue)
        binding.variant4.backgroundTintList = ContextCompat.getColorStateList(this, R.color.blue)
    }

    @SuppressLint("SetTextI18n")
    fun updateQuestion() {
        binding.ivChance.setImageResource(
            when (wrongAnswers) {
                0 -> {
                    R.drawable.smile
                }
                1 -> {
                    R.drawable.serious
                }
                2 -> {
                    R.drawable.sad
                }
                else -> {
                    R.drawable.sad
                }
            }
        )
        if (wrongAnswers > 2) {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.variant1.isEnabled = true
        binding.variant2.isEnabled = true
        binding.variant3.isEnabled = true
        binding.variant4.isEnabled = true
        resetBackgroundColor()
        if (questionNumber >= questions.size) {
            if (correctAnswers > PrefManager.getHighScore(this)) {
                PrefManager.setHighScore(this, correctAnswers)
            }
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

    fun setBackground() {
        binding.variant1.isEnabled = false
        binding.variant2.isEnabled = false
        binding.variant3.isEnabled = false
        binding.variant4.isEnabled = false
        when (questions[questionNumber].answer) {
            binding.variant1.text -> {
                binding.variant1.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.green)
            }
            binding.variant2.text -> {
                binding.variant2.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.green)
            }
            binding.variant3.text -> {
                binding.variant3.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.green)
            }
            binding.variant4.text -> {
                binding.variant4.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.green)
            }
        }
        Handler().postDelayed({
            updateQuestion()
        }, 1000)
    }
}
