package uz.gita.shoppingapp.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.ItemCartBinding

class CartItemAdapter : RecyclerView.Adapter<CartItemAdapter.Holder>() {
    private val ls: ArrayList<HomeItemVertical> = arrayListOf()
    private var countMinus: ((HomeItemVertical) -> Unit)? = null
    private var countPlus: ((HomeItemVertical) -> Unit)? = null
    private var likeState: ((HomeItemVertical) -> Unit)? = null
    private var favouriteListener: ((HomeItemVertical) -> Unit)? = null

    fun submitList(item: List<HomeItemVertical>) {
        ls.clear()
        ls.addAll(item)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.likeButtonCart.setOnClickListener {
                ls[adapterPosition].favourite = ls[adapterPosition].favourite.xor(1)
                favouriteListener?.invoke(ls[adapterPosition])
                notifyItemChanged(adapterPosition)
            }
        }

        @SuppressLint("NotifyDataSetChanged")
        fun bind(product: HomeItemVertical) {

            binding.imageCart.setImageResource(product.image)
            binding.oldpriceCart.text = product.oldPrice.toString()
            binding.newPriceCart.text = product.newPrice.toString()
            binding.monthlyPaymentCart.text = (product.newPrice / 12).toString()
            binding.itemDescription.text = product.itemDescription
            binding.oneItemCount.text = product.newPrice.toString()
            binding.itemCount.text = product.countItem.toString()


            binding.addProduct.setOnClickListener {
                val count = product.countItem
                countPlus?.invoke(product.copy(countItem = count + 1))
            }
            binding.minusProduct.setOnClickListener {
                val count = product.countItem
                countMinus?.invoke(product.copy(countItem = count - 1))
                if (product.countItem == 0) {
                    ls.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
            }
            binding.likeButtonCart.setOnClickListener {
                Log.d("pos", "bind: $adapterPosition")

                likeState?.invoke(product)
                if (product.favourite == 1) binding.likeButtonCart.setImageResource(R.drawable.checked_like_ic)
                else binding.likeButtonCart.setImageResource(R.drawable.unchecked_like_ic)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(ls[position])
    }

    fun setCountPlus(block: (HomeItemVertical) -> Unit) {
        countPlus = block
    }

    fun setCountMinus(block: (data: HomeItemVertical) -> Unit) {
        countMinus = block
    }

    fun setLikeState(block: (data: HomeItemVertical) -> Unit) {
        favouriteListener = block
    }
}