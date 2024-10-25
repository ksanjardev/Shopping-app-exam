package uz.gita.shoppingapp.screens.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.FavouriteItemsAdapter
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.ScreenFavouriteBinding

class FavouriteScreen : Fragment(), FavouriteContract.View {
    private lateinit var binding: ScreenFavouriteBinding
    private lateinit var presenter: FavouriteContract.Presenter
    private lateinit var favouriteAdapter: FavouriteItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenFavouriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favouriteAdapter = FavouriteItemsAdapter()
        presenter = FavouritePresenter(this)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    presenter.backButtonClick()
                }
            })
        binding.favouriterecyclerView.adapter = favouriteAdapter

        binding.favouriterecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        presenter.getFavouriteItems()

        binding.btnBack.setOnClickListener {
            presenter.backButtonClick()
        }
        favouriteAdapter.setFavouriteItemListener { presenter.favouriteItemClick(it) }
    }

    override fun showFavouriteItems(itemVertical: ArrayList<HomeItemVertical>) {
        favouriteAdapter.submitList(itemVertical)
    }

    override fun backToHomeScreen() {
//        requireActivity().supportFragmentManager.popBackStack()
        findNavController().popBackStack()
    }


}