package uz.gita.shoppingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.databinding.ItemIconDialogBinding

class DialogItemAdapter : Adapter<DialogItemAdapter.Holder>() {
    private var ls: List<CatalogItem> = arrayListOf()
    private var lastIndex = -1
    private var categorySelectListener: ((CatalogItem, Boolean) -> Unit)? = null
    private lateinit var checkedUncheckedList: MutableList<Boolean>

    fun submitItems(items: List<CatalogItem>) {
        ls = items
        notifyDataSetChanged()

        checkedUncheckedList = MutableList(items.size) { false }

    }

    inner class Holder(private val binding: ItemIconDialogBinding) : ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
//                if (lastIndex == adapterPosition) {
//
//                    checkedUncheckedList[adapterPosition] = !checkedUncheckedList[adapterPosition]
//                    notifyItemChanged(adapterPosition)
//                    categorySelectListener?.invoke(
//                        ls[adapterPosition],
//                        checkedUncheckedList[adapterPosition]
//                    )
//                    return@setOnClickListener
//                }
//
//                if (lastIndex != -1) {
//                    checkedUncheckedList[adapterPosition] = false
//                    notifyItemChanged(lastIndex)
//                }
//
//                checkedUncheckedList[adapterPosition] = !checkedUncheckedList[adapterPosition]
//                notifyItemChanged(adapterPosition)
//                lastIndex = adapterPosition
//                categorySelectListener?.invoke(
//                    ls[adapterPosition],
//                    checkedUncheckedList[adapterPosition]
//                )
                if (lastIndex == adapterPosition) {
                    checkedUncheckedList[adapterPosition] = !checkedUncheckedList[adapterPosition]
                    notifyItemChanged(adapterPosition)
                    categorySelectListener?.invoke(
                        ls[adapterPosition],
                        checkedUncheckedList[adapterPosition]
                    )
                    return@setOnClickListener
                }


                if (lastIndex != -1) {
                    checkedUncheckedList[lastIndex] = false
                    notifyItemChanged(lastIndex)
                }
                checkedUncheckedList[adapterPosition] = !checkedUncheckedList[adapterPosition]
                notifyItemChanged(adapterPosition)
                lastIndex = adapterPosition
                categorySelectListener?.invoke(
                    ls[adapterPosition],
                    checkedUncheckedList[adapterPosition]
                )
            }
        }

        fun bind() {
            binding.imageIcon.setImageResource(ls[adapterPosition].icon)

            if (checkedUncheckedList[adapterPosition]){
                binding.backImageContainer.setImageResource(R.drawable.dialog_item_select)
            } else{
                binding.backImageContainer.setImageResource(R.drawable.dialog_item_unselect)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        ItemIconDialogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = ls.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setCategorySelectListener(block: (CatalogItem, Boolean) -> Unit) {
        categorySelectListener = block
    }
}