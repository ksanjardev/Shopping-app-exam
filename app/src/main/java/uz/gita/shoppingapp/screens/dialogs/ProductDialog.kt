package uz.gita.shoppingapp.screens.dialogs

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.ProductEntity
import uz.gita.shoppingapp.databinding.AddProductDialogBinding

class ProductDialog : DialogFragment() {
    private lateinit var binding: AddProductDialogBinding
    private val productDao by lazy { AppDatabase.instance.productItem() }
    private var imageUi: Uri? = null
    private lateinit var getContent: ActivityResultLauncher<Intent>
    private val args: ProductDialogArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddProductDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            resources.displayMetrics.heightPixels * 2 / 3
        )
        window?.decorView?.setPadding(marginInPixels, 0, marginInPixels, 0)


        binding.submitButton.setOnClickListener {
            if (binding.categoryName.text.toString().trim().isEmpty()
                || binding.productDescription.text.toString().trim().isEmpty()
                || binding.oldPrice.text.toString().trim().isEmpty()
                || binding.newPrice.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(context, "Barchasi to'ldiring!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (imageUi == null) {
                Toast.makeText(context, "Rasm yuklang!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(context, "Qo'shildi", Toast.LENGTH_SHORT).show()
            setFragmentResult("productKey", bundleOf("productAdded" to true))

            dialog?.dismiss()


        }



    }
}