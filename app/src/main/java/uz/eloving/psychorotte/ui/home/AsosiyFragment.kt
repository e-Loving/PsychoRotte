package uz.eloving.psychorotte.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.eloving.psychorotte.activities.QuizActivity
import uz.eloving.psychorotte.databinding.FragmentAsosiyBinding

class AsosiyFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentAsosiyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAsosiyBinding.inflate(inflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        binding.tvPlay.text = name
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