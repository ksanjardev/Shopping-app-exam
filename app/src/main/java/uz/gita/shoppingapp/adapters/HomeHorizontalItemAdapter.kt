package uz.gita.shoppingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.databinding.ItemHomeHorizontalBinding

class HomeHorizontalItemAdapter : RecyclerView.Adapter<HomeHorizontalItemAdapter.Holder>() {
    private val ls: ArrayList<Int> = arrayListOf()

    fun submitList(items: ArrayList<Int>){
        ls.clear()
        ls.addAll(items)
    }

    inner class Holder(private val binding: ItemHomeHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.image.setImageResource(ls[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        ItemHomeHorizontalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }
}