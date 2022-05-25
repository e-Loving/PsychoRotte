package uz.eloving.psychorotte.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGo.setOnClickListener {
            if (binding.etName.text.toString().isEmpty()) {
                Toast.makeText(this, "Ism kiritish majburiy !", Toast.LENGTH_LONG).show()
            } else {
                if (binding.pinview.text.toString().length == 4) {
                    PrefManager.setName(this, binding.pinview.text.toString())
                    PrefManager.setToggle(this, true)
                    PrefManager.setName(this, binding.etName.text.toString())
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                if (binding.pinview.text.toString().isEmpty()) {
                    PrefManager.setName(this, binding.etName.text.toString())
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
}