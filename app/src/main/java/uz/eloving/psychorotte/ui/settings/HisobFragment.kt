package uz.eloving.psychorotte.ui.settings

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.eloving.psychorotte.CodeConfirmationActivity
import uz.eloving.psychorotte.LoginActivity
import uz.eloving.psychorotte.SetPasswordActivity
import uz.eloving.psychorotte.SetUsernameActivity
import uz.eloving.psychorotte.databinding.FragmentHisobBinding

class HisobFragment : Fragment() {

    private var _binding: FragmentHisobBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHisobBinding.inflate(inflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
        binding.swSwitch.isChecked =
            sharedPreferences.getString("password", "password") != "password"
        binding.swSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                sharedPreferences.edit().putBoolean("toggle", false).apply()
                sharedPreferences.edit().putBoolean("askpassword", false).apply()
            } else if (isChecked) {
                if (sharedPreferences.getString("password", "password") == "password") {
                    sharedPreferences.edit().putBoolean("toggle", false).apply()
                    binding.swSwitch.isChecked = false
                    val intent = Intent(requireContext(), SetPasswordActivity::class.java)
                    startActivity(intent)
                }
            }

//            sharedPreferences.edit().putBoolean("toggle", isChecked).apply()
        }
        binding.mbParol.setOnClickListener {
            if (sharedPreferences.getString("password", "password") != "password") {
                sharedPreferences.edit().putBoolean("setnewpassword", true).apply()
                sharedPreferences.edit().putBoolean("askpassword", false).apply()
                val intent = Intent(requireContext(), CodeConfirmationActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(requireContext(), SetPasswordActivity::class.java)
                startActivity(intent)
            }
        }
        binding.mbUsername.setOnClickListener {
            if (sharedPreferences.getString("password", "password") == "password") {
                val intent = Intent(requireContext(), SetUsernameActivity::class.java)
                startActivity(intent)
            } else {
                sharedPreferences.edit().putBoolean("askpassword", true).apply()
                val intent = Intent(requireContext(), CodeConfirmationActivity::class.java)
                startActivity(intent)
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}