package uz.eloving.psychorotte.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.activities.CodeConfirmationActivity
import uz.eloving.psychorotte.activities.SetPasswordActivity
import uz.eloving.psychorotte.activities.SetUsernameActivity
import uz.eloving.psychorotte.databinding.FragmentHisobBinding

class HisobFragment : Fragment() {

    private var _binding: FragmentHisobBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHisobBinding.inflate(inflater, container, false)
        binding.swSwitch.isChecked =
            PrefManager.getPassword(requireActivity()) != "password" && PrefManager.getToggle(
                requireActivity()
            )
        binding.swSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                PrefManager.setToggle(requireActivity(), false)
                PrefManager.setAskPassword(requireActivity(), false)
            } else if (isChecked) {
                PrefManager.setToggle(requireActivity(), true)
                if (PrefManager.getPassword(requireActivity()) == "password") {
                    PrefManager.setToggle(requireActivity(), false)
                    binding.swSwitch.isChecked = false
                    val intent = Intent(requireContext(), SetPasswordActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        binding.mbParol.setOnClickListener {
            if (PrefManager.getPassword(requireActivity()) != "password") {
                PrefManager.setNewPassword(requireActivity(), true)
                PrefManager.setAskPassword(requireActivity(), false)
                val intent = Intent(requireContext(), CodeConfirmationActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(requireContext(), SetPasswordActivity::class.java)
                startActivity(intent)
            }
        }
        binding.mbUsername.setOnClickListener {
            if (PrefManager.getPassword(requireActivity()) == "password") {
                startActivity(Intent(requireContext(), SetUsernameActivity::class.java))
            } else {
                PrefManager.setAskPassword(requireActivity(), true)
                startActivity(Intent(requireContext(), CodeConfirmationActivity::class.java))
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}