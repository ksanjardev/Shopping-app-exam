package uz.gita.shoppingapp.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.data.entity.ProductEntity
import uz.gita.shoppingapp.databinding.ItemCatalogBinding
import uz.gita.shoppingapp.databinding.ItemHomeVerticalBinding

class ProductAdapter: Adapter<ProductAdapter.Holder>() {
    private val ls: ArrayList<ProductEntity> = arrayListOf()


    fun submitList(items: List<ProductEntity>){
        ls.clear()
        ls.addAll(items)
        notifyDataSetChanged()
    }

    class Holder(private val binding: ItemHomeVerticalBinding): ViewHolder(binding.root) {

        fun bind(product: ProductEntity){
            if (product.isDefault == 1) binding.image.setImageResource(product.image)
            else Glide.with(binding.image.context).load(product.imageUri).into(binding.image)

            binding.descriptionImage.text = product.productName
            binding.newPrice.text = product.newPrice

            binding.oldPrice.text = product.oldPrice
            binding.oldPrice.paintFlags = binding.oldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            binding.oldPriceSom.paintFlags = binding.oldPriceSom.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

            binding.monthlyPayment.text = (product.newPrice.toInt() / 12).toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemHomeVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(ls[position])
    }

}