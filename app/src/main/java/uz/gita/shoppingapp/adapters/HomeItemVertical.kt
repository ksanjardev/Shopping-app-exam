package uz.gita.shoppingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.ItemHomeVerticalBinding

class HomeItemVerticalAdapter : RecyclerView.Adapter<HomeItemVerticalAdapter.Holder>() {
    private val ls: ArrayList<HomeItemVertical> = arrayListOf()
    private var favouriteListener: ((Int, Int) -> Unit)? = null
    private var cartListener: ((HomeItemVertical) -> Unit)? = null

    fun submitList(item: ArrayList<HomeItemVertical>) {
        ls.clear()
        ls.addAll(item)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemHomeVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.addToCartButton.setOnClickListener {
                ls[adapterPosition].cart = ls[adapterPosition].cart.xor(1)
                cartListener?.invoke(ls[adapterPosition])
                notifyItemChanged(adapterPosition)
            }
            binding.favouriteButton.setOnClickListener {
                ls[adapterPosition].favourite = ls[adapterPosition].favourite.xor(1)
                favouriteListener?.invoke(ls[adapterPosition].id, ls[adapterPosition].favourite)
                notifyItemChanged(adapterPosition)
            }

        }

        fun bind() {
            binding.image.setImageResource(ls[adapterPosition].image)
            binding.descriptionImage.text = ls[adapterPosition].itemDescription
            binding.oldPrice.text = ls[adapterPosition].oldPrice.toString()
            binding.newPrice.text = ls[adapterPosition].newPrice.toString()
            binding.monthlyPayment.text = ls[adapterPosition].monthlyPayment.toString()

            binding.favouriteButton.setImageResource(
                if (ls[adapterPosition].favourite == 0) R.drawable.unchecked_like_ic
                else R.drawable.checked_like_ic
            )
            binding.addToCartButton.setImageResource(
                if (ls[adapterPosition].cart == 0) R.drawable.unchecked_cart_ic
                else R.drawable.checked_cart_ic
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemHomeVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setFavouriteListener(block: (Int, Int) -> Unit) {
        favouriteListener = block
    }

    fun setCartListener(block: (HomeItemVertical) -> Unit) {
        cartListener = block
    }
}