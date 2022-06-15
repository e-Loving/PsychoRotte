package uz.eloving.psychorotte

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.eloving.psychorotte.databinding.ItemCardViewBinding

class AdapterCards() : RecyclerView.Adapter<AdapterCards.ViewHolder>() {
    private var list = ArrayList<MockData.DataOfCards>()


    var onItemCLick: ((MockData.DataOfCards) -> Unit)? = null


    inner class ViewHolder(private val binding: ItemCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MockData.DataOfCards) {
            binding.ivTravel.setImageResource(data.image)
            binding.cvLevel.setCardBackgroundColor(Color.parseColor(data.cardBg))
            binding.tvType.text = data.type
            binding.btnStartLevel.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(data.btnBg))
            binding.tvLevelLevel.text = data.level
            binding.highScore.text = data.highScore
        }

        init {
            binding.btnStartLevel.setOnClickListener {

                onItemCLick?.invoke(list[adapterPosition])
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: ArrayList<MockData.DataOfCards>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}