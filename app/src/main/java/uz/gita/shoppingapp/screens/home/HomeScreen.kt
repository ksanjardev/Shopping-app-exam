package uz.gita.shoppingapp.screens.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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
    private val handler by lazy { Handler(Looper.getMainLooper()) }
    private var query: String? = null

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
        verticalItemAdapter.setCartListener { it ->
            presenter.updateCartData(it)
        }

        presenter.getAllItem()
        binding.goFavouriteScreenButton.setOnClickListener { presenter.favouriteItemClick() }
        showSearchedWord()
    }

    override fun showAllItem(homeItemVertical: List<HomeItemVertical>) {
        verticalItemAdapter.submitList(homeItemVertical)
    }

    override fun showFavouriteScreen() {
        findNavController().navigate(R.id.action_home_to_favouriteScreen)
    }

    override fun showToast(id: Int, cartCount: Int) {
        Toast.makeText(requireContext(), " Item $id, product $cartCount", Toast.LENGTH_SHORT).show()
    }

    private fun showSearchedWord() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                this@WordListScreen.query = query
//                handler.removeCallbacksAndMessages(null)
//                if (query == null) presenter.getAllWords()
//                else presenter.getSearchWords(this@WordListScreen.query!!)
//                dictAdapter
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                this@HomeScreen.query = newText
                if (query.isNullOrEmpty()) {
                    verticalItemAdapter.setSearchText("")
                    verticalItemAdapter.submitList(emptyList())
                    presenter.getAllItem()
                } else {
                    verticalItemAdapter.setSearchText(newText.toString())
                    handler.removeCallbacksAndMessages(null)
                    handler.postDelayed({
                        presenter.getSearchWords(query!!)
                    }, 100)
                }
                return true
            }
        })
    }
}