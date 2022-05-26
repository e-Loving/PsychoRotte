package uz.eloving.psychorotte.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.eloving.psychorotte.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val correct = intent.getIntExtra("correct" , 0)
        binding.result.text = correct.toString()
    }
}


