package uz.gita.shoppingapp.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.databinding.ItemCatalogBinding

class CatalogItemAdapter : RecyclerView.Adapter<CatalogItemAdapter.Holder>() {
    private var ls: List<CatalogItem>? = null
    private lateinit var itemListener: (catalog: CatalogItem) -> Unit

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(item: List<CatalogItem>) {
        ls = item
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemListener.invoke(ls?.get(adapterPosition)!!)
            }
        }

        fun bind(data: CatalogItem) {
            Log.d("aaa", "bind: $data")
            binding.categoryIcon.setImageResource(data.icon)
            binding.categoryName.text = data.iconText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(ls!![position])
        Log.d("AAA", "onBindViewHolder: ${ls?.size}")
    }
    fun setItemListener(block: (CatalogItem)-> Unit){
        itemListener = block
    }
}