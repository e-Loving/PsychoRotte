package uz.eloving.psychorotte.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import uz.eloving.psychorotte.AdapterCards
import uz.eloving.psychorotte.MockData
import uz.eloving.psychorotte.PrefManager
import uz.eloving.psychorotte.activities.QuizActivity
import uz.eloving.psychorotte.databinding.FragmentAsosiyBinding

class AsosiyFragment : Fragment() {

    private var _binding: FragmentAsosiyBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AdapterCards
    private var cards = ArrayList<AdapterCards>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = AdapterCards()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAsosiyBinding.inflate(inflater, container, false)
        val name = PrefManager.getName(requireContext())
        binding.tvPlay.text = name
        binding.rvCards.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvCards.adapter = adapter

        adapter.updateList(MockData.getDataOfCards(requireContext()))

        adapter.onItemCLick = {
            if (it.level == "1-Daraja") {
                startActivity(Intent(requireContext(), QuizActivity::class.java))
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}