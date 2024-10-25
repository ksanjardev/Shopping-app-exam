package uz.gita.shoppingapp.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.HomeHorizontalItemAdapter
import uz.gita.shoppingapp.databinding.HomeScreenBinding

class HomeScreen : Fragment(), HomeContract.View {
    private val list: ArrayList<Int> = arrayListOf(
        R.drawable.item_horizontal_1,
        R.drawable.item_horizontal_2,
        R.drawable.item_horizontal_3,
        R.drawable.item_horizontal_1,
        R.drawable.item_horizontal_2,
        R.drawable.item_horizontal_3,
        R.drawable.item_horizontal_1,
        R.drawable.item_horizontal_2,
        R.drawable.item_horizontal_3,
    )

    private lateinit var presenter: HomeContract.Presenter
    private lateinit var horizontalItemAdapter: HomeHorizontalItemAdapter
    private lateinit var binding: HomeScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenter(this)
        horizontalItemAdapter = HomeHorizontalItemAdapter()
        binding.pager.adapter = horizontalItemAdapter
        horizontalItemAdapter.submitList(list)
    }

}