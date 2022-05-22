package uz.eloving.psychorotte

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.databinding.ActivitySetUsernameBinding

class SetUsernameActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySetUsernameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySetUsernameBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)
        binding.btnConfirm.setOnClickListener {
            if (binding.etUsername.text.toString().isNotEmpty()) {
                sharedPreferences.edit().putString("name", binding.etUsername.text.toString())
                    .apply()
                sharedPreferences.edit().putBoolean("askpassword", false).apply()
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