package uz.eloving.psychorotte.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.eloving.psychorotte.R
import uz.eloving.psychorotte.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val correct = intent.getIntExtra("correct", 0)
        val all = intent.getIntExtra("all", 0)
        if (correct == all) {
            binding.emotion.setImageResource(R.drawable.smile)
            binding.result.text =
                "Tabriklaymiz sizning din borasida egallagan bilimingiz havas qilsa arzigulik.\nBiz siz bilan faxirlanamiz !"
        } else if (correct > all / 2) {
            binding.emotion.setImageResource(R.drawable.serious)
            binding.result.text =
                "Qoyil siz kam foizli obunachilarimiz qatoridasiz.\nOlg'a yurishda davom eting !"
        } else if (correct < all / 2) {
            binding.result.text =
                "Ilm olishda davom eting, hali o'rganadigan bilimingiz oldinda.\nBiz sizga ishonamiz !"
            binding.emotion.setImageResource(R.drawable.sad)
        }
        binding.btnEnd.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}


