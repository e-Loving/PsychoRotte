package uz.eloving.psychorotte.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)


        binding.btnGo.setOnClickListener {
            if (binding.etName.text.toString().isEmpty()) {
                Toast.makeText(this, "Ism kiritish majburiy !", Toast.LENGTH_LONG).show()
            } else {
                if (binding.pinview.text.toString().length == 4) {
                    sharedPreferences.edit()
                        .putString("password", binding.pinview.text.toString()).apply()
                    sharedPreferences.edit().putBoolean("toggle", true).apply()
                    val name = binding.etName.text.toString()
                    sharedPreferences.edit().putString("name", name).apply()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                if (binding.pinview.text.toString().isEmpty()) {
                    val name = binding.etName.text.toString()
                    sharedPreferences.edit().putString("name", name).apply()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else if (binding.pinview.text.toString()
                        .isNotEmpty() && binding.pinview.text.toString().length != 4
                ) {
                    Toast.makeText(
                        this,
                        "Parol 4 raqamdan tashkil topgan bo'lishi kerak",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private lateinit var binding: ActivityLoginBinding
}