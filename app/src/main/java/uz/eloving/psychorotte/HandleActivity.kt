package uz.eloving.psychorotte

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView

class HandleActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle)
        sharedPreferences = this.getSharedPreferences("app", Context.MODE_PRIVATE)
        Handler().postDelayed({
            val intent =
                when {
                    sharedPreferences.getString("name", "name") == "name" -> {
                        Intent(this, LoginActivity::class.java)
                    }
                    sharedPreferences.getString("password", "password") != "password" -> {
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