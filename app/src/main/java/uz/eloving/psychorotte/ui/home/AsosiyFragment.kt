package uz.eloving.psychorotte.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.activities.QuizActivity
import uz.eloving.psychorotte.databinding.FragmentAsosiyBinding

class AsosiyFragment : Fragment() {

    private var _binding: FragmentAsosiyBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAsosiyBinding.inflate(inflater, container, false)
        val name = PrefManager.getName(requireContext())
        binding.tvPlay.text = name
        binding.highScore.text = "Yuqori - ${PrefManager.getHighScore(requireContext())}"
        binding.btnStartBeginner.setOnClickListener {
            val intent  = Intent(requireContext(), QuizActivity::class.java)
            startActivity(intent)
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}