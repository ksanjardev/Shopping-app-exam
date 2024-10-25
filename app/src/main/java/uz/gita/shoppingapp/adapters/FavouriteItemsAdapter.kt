package uz.gita.shoppingapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.ItemHomeVerticalBinding

class FavouriteItemsAdapter : RecyclerView.Adapter<FavouriteItemsAdapter.Holder>() {
    private val ls: ArrayList<HomeItemVertical> = arrayListOf()
    private var favouriteItemListener: ((HomeItemVertical) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(item: ArrayList<HomeItemVertical>) {
        ls.clear()
        ls.addAll(item)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemHomeVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.favouriteButton.setOnClickListener {

                if (ls[adapterPosition].favourite == 1) {
                    binding.favouriteButton.setImageResource(R.drawable.unchecked_like_ic)
                    favouriteItemListener?.invoke(ls[adapterPosition])
                    ls.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }

            }
        }

        fun bind() {
            binding.image.setImageResource(ls[adapterPosition].image)
            binding.descriptionImage.text = ls[adapterPosition].itemDescription
            binding.oldPrice.text = ls[adapterPosition].oldPrice.toString()
            binding.newPrice.text = ls[adapterPosition].newPrice.toString()
            binding.monthlyPayment.text = ls[adapterPosition].monthlyPayment.toString()

            if (ls[adapterPosition].favourite == 1) binding.favouriteButton.setImageResource(R.drawable.checked_like_ic)
            else binding.favouriteButton.setImageResource(R.drawable.unchecked_like_ic)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemHomeVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setFavouriteItemListener(block: (HomeItemVertical) -> Unit) {
        favouriteItemListener = block
    }
}