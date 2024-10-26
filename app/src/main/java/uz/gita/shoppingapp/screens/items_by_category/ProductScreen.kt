package uz.gita.shoppingapp.screens.items_by_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.ProductAdapter
import uz.gita.shoppingapp.data.entity.ProductEntity
import uz.gita.shoppingapp.databinding.ProductScreenBinding


class ProductScreen : Fragment(), ProductContract.View {

    private lateinit var binding: ProductScreenBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var presenter:ProductContract.Presenter
    private val args: ProductScreenArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ProductScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ProductPresenter(this, args.catalogItem.id)
        productAdapter = ProductAdapter()
        binding.productRecyclerView.adapter = productAdapter



    }

    override fun showProducts(items: List<ProductEntity>) {
        productAdapter.submitList(items)
    }

}