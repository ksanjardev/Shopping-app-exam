package uz.gita.shoppingapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.data.entity.ProfileItemEntity
import uz.gita.shoppingapp.databinding.ItemProfileBinding

class ProfileItemAdapter : RecyclerView.Adapter<ProfileItemAdapter.Holder>() {
    private val ls: ArrayList<ProfileItemEntity> = arrayListOf()
    private var itemListener: ((ProfileItemEntity) -> Unit)? = null

    fun submitList(item: List<ProfileItemEntity>) {
        ls.clear()
        ls.addAll(item)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

            init {
                binding.second.setOnClickListener{
                    itemListener?.invoke(ls[adapterPosition])
                }
            }

        fun bind() {
            binding.iconProfile.setImageResource(ls[adapterPosition].icon)
            binding.textIconProfile.text = ls[adapterPosition].iconText

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setItemListener(block: (ProfileItemEntity)->Unit){
        itemListener = block
    }

}