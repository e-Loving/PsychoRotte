package uz.eloving.psychorotte.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.eloving.psychorotte.databinding.FragmentKitoblarBinding

class KitoblarFragment : Fragment() {

    private var _binding: FragmentKitoblarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKitoblarBinding.inflate(inflater, container, false)
        return binding.root
        binding.imageView.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}