package uz.gita.shoppingapp.screens.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.DialogItemAdapter
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.databinding.AddCatalogDialogBinding

class NewCatalogDialog : DialogFragment() {
    private lateinit var binding: AddCatalogDialogBinding
    private lateinit var dialogItemAdapter: DialogItemAdapter
    private var imageSelected = false
    private var imgEx = R.drawable.headphone_ic
    private val catalogDao by lazy { AppDatabase.instance.catalogItem() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddCatalogDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogItemAdapter = DialogItemAdapter()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = dialog?.window
        val params = window?.attributes
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        params?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = params

        val marginInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            24f,
            resources.displayMetrics
        ).toInt()

        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window?.decorView?.setPadding(marginInPixels, 0, marginInPixels, 0)

        dialogItemAdapter.setCategorySelectListener { catalogItem, isSelected ->
            imageSelected = isSelected
            if (imageSelected) {
                imgEx = catalogItem.icon
            }
        }

        binding.itemRecyclerViewDialog.adapter = dialogItemAdapter
        dialogItemAdapter.submitItems(catalogDao.getAllItem())

        binding.submitButton.setOnClickListener {
            if (binding.categoryName.text.toString().trim().isEmpty()) {
                Toast.makeText(context, "Fill in the blank!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!imageSelected) {
                Toast.makeText(context, "Choose icon!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            catalogDao.insertItem(
                CatalogItem(0, imgEx, binding.categoryName.text.toString().trim())
            )
            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show()
            setFragmentResult("requestKey", bundleOf("categoryAdded" to true))
            dialog?.dismiss()
        }

    }
}