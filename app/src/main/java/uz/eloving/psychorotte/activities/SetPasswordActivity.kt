package uz.eloving.psychorotte.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.databinding.ActivitySetPasswordBinding

class SetPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnConfirm.setOnClickListener {
            if (binding.pinview.text.toString().length != 4) {
                Toast.makeText(
                    this,
                    "Parol 4 raqamdan tashkil topgan bo'lishi kerak !",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                PrefManager.setPassword(this, binding.pinview.text.toString())
                PrefManager.setToggle(this, true)
                PrefManager.setNewPassword(this, false)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.btnDelete.setOnClickListener {
            PrefManager.setPassword(this, "password")
            PrefManager.setDeleted(this, false)
            PrefManager.setToggle(this, false)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }



        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
    }
}