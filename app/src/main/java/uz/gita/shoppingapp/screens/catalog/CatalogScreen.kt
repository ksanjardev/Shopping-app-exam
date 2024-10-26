package uz.gita.shoppingapp.screens.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    }

    override fun showCatalogItems(items: List<CatalogItem>) {
        Log.d("VVV", "onViewCreated: ${items.size}")
        catalogItemAdapter.submitList(items)
    }
}