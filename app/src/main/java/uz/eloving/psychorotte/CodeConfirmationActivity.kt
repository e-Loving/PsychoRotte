package uz.eloving.psychorotte

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.databinding.ActivityCodeConfirmationBinding

class CodeConfirmationActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityCodeConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)
        binding = ActivityCodeConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnConfirm.setOnClickListener {
            if (binding.etPassword.text.toString() == sharedPreferences.getString(
                    "password",
                    "password"
                )
            ) {
                when {
                    sharedPreferences.getBoolean("askpassword", false) -> {
                        val intent = Intent(this, SetUsernameActivity::class.java)
                        startActivity(intent)
                    }
                    sharedPreferences.getBoolean("setnewpassword", false) -> {
                        val intent = Intent(this, SetPasswordActivity::class.java)
                        startActivity(intent)
                    }
                    else -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }

            } else {
                Toast.makeText(this, "Parol noto'g'ri !", Toast.LENGTH_SHORT).show()
            }
        }
        binding.ibBack.setOnClickListener {
            sharedPreferences.edit().putBoolean("askpassword", false).apply()
            onBackPressed()
        }
    }
}