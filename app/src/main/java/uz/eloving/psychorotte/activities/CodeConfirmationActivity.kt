package uz.eloving.psychorotte.activities

import android.annotation.SuppressLint
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
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)
        binding = ActivityCodeConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvWelcome.text = "Parolni kiriting\n${sharedPreferences.getString("name", "Boss")}!"
        binding.pinview.setOnClickListener {
            // If confirm button clicked then the programm checks the password with edittext field if true,
            // next action will start otherwise toast will appear
            if (binding.pinview.text.toString() == sharedPreferences.getString(
                    "password",
                    "password"
                )
            ) {
                val intent = when {
                    // In hisob fragment, if ism sozlash button clicked then askpassword cache will be stored
                    // otherwise first statement will be false
                    sharedPreferences.getBoolean("askpassword", false) -> {
                        Intent(this, SetUsernameActivity::class.java)
                    }
                    // In hisob fragment, if parol sozlash button clicked then setnewpassword cache will be stored
                    // otherwise second statement will be false
                    sharedPreferences.getBoolean("setnewpassword", false) -> {
                        Intent(this, SetPasswordActivity::class.java)
                    }
                    // If two caches wouldn't be stored then the code below will run
                    else -> {
                        Intent(this, MainActivity::class.java)
                    }
                }
                startActivity(intent)
                finish()

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