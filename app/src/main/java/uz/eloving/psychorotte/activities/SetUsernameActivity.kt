package uz.eloving.psychorotte.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.databinding.ActivitySetUsernameBinding

class SetUsernameActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetUsernameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySetUsernameBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnConfirm.setOnClickListener {
            if (binding.etName.text.toString().isNotEmpty()) {
                PrefManager.setName(this, binding.etName.text.toString())
                PrefManager.setAskPassword(this, false)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Foydalanuvchi nomi bo'sh", Toast.LENGTH_SHORT).show()
            }
        }
        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
    }
}