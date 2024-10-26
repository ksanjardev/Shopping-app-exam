package uz.gita.shoppingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.ItemCartBinding

class CartItemAdapter : RecyclerView.Adapter<CartItemAdapter.Holder>() {
    private val ls: ArrayList<HomeItemVertical> = arrayListOf()
    private var countMinus: ((Int, Int) -> Unit)? = null
    private var countPlus: ((Int, Int) -> Unit)? = null
    private var likeState: ((Int, Int) -> Unit)? = null


    fun submitList(item: List<HomeItemVertical>) {
        ls.clear()
        ls.addAll(item)
        notifyDataSetChanged()
    }

    fun clearList() {
        ls.clear()
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind() {

            binding.imageCart.setImageResource(ls[adapterPosition].image)
            binding.oldpriceCart.text = ls[adapterPosition].oldPrice.toString()
            binding.newPriceCart.text = ls[adapterPosition].newPrice.toString()
            binding.itemDescription.text = ls[adapterPosition].itemDescription
            binding.oneItemCount.text = ls[adapterPosition].newPrice.toString()
            binding.itemCount.text = ls[adapterPosition].countItem.toString()


            binding.addProduct.setOnClickListener {
                countPlus?.invoke(ls[adapterPosition].id, ls[adapterPosition].countItem)
            }
            binding.minusProduct.setOnClickListener {
                countMinus?.invoke(ls[adapterPosition].id, ls[adapterPosition].countItem)
                if (ls[adapterPosition].countItem == 1) {
                    ls.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)

                }
            }
            binding.likeButtonCart.setOnClickListener {
                likeState?.invoke(ls[adapterPosition].id, ls[adapterPosition].favourite)
                binding.likeButtonCart.setImageResource(
                    if (ls[adapterPosition].favourite == 1) R.drawable.checked_like_ic
                    else R.drawable.unchecked_cart_ic
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setCountPlus(block: (Int, Int) -> Unit) {
        countPlus = block
    }

    fun setCountMinus(block: (Int, Int) -> Unit) {
        countMinus = block
    }

    fun setLikeState(block: (Int, Int) -> Unit) {
        likeState = block
    }
}