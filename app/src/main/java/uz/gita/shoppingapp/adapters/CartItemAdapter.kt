package uz.gita.shoppingapp.adapters

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.ItemCartBinding


class CartItemAdapter : RecyclerView.Adapter<CartItemAdapter.Holder>() {
    private val ls: ArrayList<HomeItemVertical> = arrayListOf()
    private var countMinus: ((HomeItemVertical) -> Unit)? = null
    private var countPlus: ((HomeItemVertical) -> Unit)? = null
    private var listener: (() -> Unit)? = null
    private var favouriteListener: ((HomeItemVertical) -> Unit)? = null

    fun submitList(item: List<HomeItemVertical>) {
        ls.clear()
        ls.addAll(item)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {




        @SuppressLint("NotifyDataSetChanged")
        fun bind(product: HomeItemVertical) {

            binding.imageCart.setImageResource(product.image)
            binding.oldPriceCart.text = product.oldPrice.toString()
            binding.oldPriceCart.paintFlags = binding.oldPriceCart.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            binding.oldPriceText.paintFlags = binding.oldPriceText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

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
                if (product.countItem > 1) {
                    countMinus?.invoke(product.copy(countItem = count - 1))
                }else if(product.countItem==1){
                    countMinus?.invoke(product.copy(cart = 0, countItem = 0))
                    listener?.invoke()
                }
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
    fun setOnListener(block:()->Unit){
        listener= block
    }
}