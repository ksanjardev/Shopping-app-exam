package uz.gita.shoppingapp.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.HomeHorizontalItemAdapter
import uz.gita.shoppingapp.adapters.HomeItemVerticalAdapter
import uz.gita.shoppingapp.data.entity.HomeItemVertical
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
    private lateinit var verticalItemAdapter: HomeItemVerticalAdapter
    private lateinit var binding: HomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenter(this)
        horizontalItemAdapter = HomeHorizontalItemAdapter()
        binding.pager.adapter = horizontalItemAdapter
        horizontalItemAdapter.submitList(list)

        verticalItemAdapter = HomeItemVerticalAdapter()
        binding.verticalRecyclerView.adapter = verticalItemAdapter
        binding.verticalRecyclerView.layoutManager = GridLayoutManager(context, 2)

        verticalItemAdapter.setFavouriteListener { pos, item ->
            presenter.updateFavouriteData(pos, item)
        }
        verticalItemAdapter.setCartListener { pos, item ->
            presenter.updateCartData(pos, item)
        }

        presenter.getAllItem()
        binding.goFavouriteScreenButton.setOnClickListener{presenter.favouriteItemClick()}
    }

    override fun showAllItem(homeItemVertical: ArrayList<HomeItemVertical>) {
        verticalItemAdapter.submitList(homeItemVertical)
    }

    override fun showFavouriteScreen() {
        findNavController().navigate(R.id.action_home_to_favouriteScreen)
    }

}