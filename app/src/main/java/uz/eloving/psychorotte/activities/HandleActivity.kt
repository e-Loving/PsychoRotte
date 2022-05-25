package uz.eloving.psychorotte.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import uz.eloving.psychorotte.R

class HandleActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle)
        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)
        // If user logged before then login activity will not appear more
        Handler().postDelayed({
            val intent =
                when {
                    sharedPreferences.getString("name", "name") == "name" -> {
                        Intent(this, LoginActivity::class.java)
                    }
                    sharedPreferences.getBoolean("toggle", false) -> {
                        Intent(this, CodeConfirmationActivity::class.java)
                    }
                    else -> {
                        Intent(this, MainActivity::class.java)
                    }
                }
            startActivity(intent)
            finish()
        }, 3000)
    }
}