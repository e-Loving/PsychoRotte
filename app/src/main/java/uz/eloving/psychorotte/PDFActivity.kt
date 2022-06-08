package uz.eloving.psychorotte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.eloving.psychorotte.databinding.ActivityPdfactivityBinding

class PDFActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPdfactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}