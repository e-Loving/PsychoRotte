package uz.eloving.psychorotte

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.databinding.ActivitySetPasswordBinding

class SetPasswordActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)
        binding.btnConfirm.setOnClickListener {
            if(binding.etPassword.text.toString().length != 4){
                Toast.makeText(this, "Parol 4 raqamdan tashkil topgan bo'lishi kerak !", Toast.LENGTH_LONG).show()
            }else{
                sharedPreferences.edit().putString("password", binding.etPassword.text.toString()).apply()
                sharedPreferences.edit().putBoolean("toggle", true).apply()
                sharedPreferences.edit().putBoolean("setnewpassword", false).apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
    }
}