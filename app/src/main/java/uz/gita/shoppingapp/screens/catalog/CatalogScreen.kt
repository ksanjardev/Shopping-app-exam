package uz.gita.shoppingapp.screens.catalog

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.CatalogItemAdapter
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.databinding.CatalogScreenBinding

class CatalogScreen : Fragment(), CatalogContract.View {
    private lateinit var binding: CatalogScreenBinding
    private lateinit var catalogItemAdapter: CatalogItemAdapter
    private lateinit var presenter: CatalogPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = CatalogScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CatalogPresenter(this)
        catalogItemAdapter = CatalogItemAdapter()
        binding.catalogRecyclerView.adapter = catalogItemAdapter
        binding.catalogRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        presenter.getAllCatalogItem()

        catalogItemAdapter.setItemListener { presenter.catalogItemClick(it) }

        binding.addCategoryButton.setOnClickListener{
            presenter.addCategoryButtonClick()
        }
    }

    override fun showCatalogItems(items: List<CatalogItem>) {
        catalogItemAdapter.submitList(items)
    }

    override fun openProductScreen(catalogItem: CatalogItem) {
        findNavController().navigate(CatalogScreenDirections.actionCatalogToProductScreen(catalogItem))
    }

    private var isClicked = true

    override fun openNewCategoryDialog() {
        if (isClicked){
            findNavController().navigate(R.id.action_catalog_to_newCatalogDialog)
            isClicked = false
            Handler().postDelayed({ isClicked = true }, 200)
        }
    }
}