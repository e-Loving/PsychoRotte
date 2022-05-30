package uz.eloving.psychorotte.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.R

class HandleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle)
        // If user logged before then login activity will not appear more
        Handler().postDelayed({
            val intent =
                when {
                    PrefManager.getName(this) == "Boss" -> {
                        Intent(this, LoginActivity::class.java)
                    }
                    PrefManager.getToggle(this) -> {
                        Intent(this, CodeConfirmationActivity::class.java)
                    }
                    else -> {
                        Intent(this, MainActivity::class.java)
                    }
                }
            startActivity(intent)
            finish()
        }, 1000)
    }
}