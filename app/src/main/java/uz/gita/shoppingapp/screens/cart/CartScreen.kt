package uz.gita.shoppingapp.screens.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import uz.gita.shoppingapp.adapters.CartItemAdapter
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.databinding.CartScreenBinding

class CartScreen : Fragment(), CartContract.View {
    private lateinit var binding: CartScreenBinding
    private lateinit var presenter: CartContract.Presenter
    private lateinit var cartItemAdapter: CartItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CartScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CartPresenter(this)
        cartItemAdapter = CartItemAdapter()
        binding.cartRecyclerView.adapter = cartItemAdapter
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(context)

        cartItemAdapter.setCountPlus {
            presenter.addButtonClick(it)
            showData()
        }

        showData()

        cartItemAdapter.setCountMinus {
            presenter.minusButtonClick(it)
            showData()
        }
        cartItemAdapter.setOnListener {
            presenter.updateItems()
        }

        cartItemAdapter.setLikeState {
            presenter.setLikeState(it)
            showData()
        }

        binding.payButton.setOnClickListener {
            presenter.buttonPayClick()
            cartItemAdapter.submitList(emptyList())
            binding.totalProductCount.text = "0"
            binding.totalPrice.text = "0"
            binding.totalProductCount.text = "0"
        }

    }

    private fun showData() {
        cartItemAdapter.submitList(presenter.getAllCartItems())
        presenter.setData()
    }

    override fun showBasketProductsSize(size: Int) {
        binding.totalProductCount.text = size.toString()
    }

    override fun showSumPrice(sum: Int) {
        binding.totalPrice.text = sum.toString()
    }

    override fun showTotalProductCount(totalCount: Int) {
        binding.productCountInCart.text = totalCount.toString()
    }

    override fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun setData(allCart: List<HomeItemVertical>) {
        Log.d("AAA", "setData: ${allCart.size}")
        cartItemAdapter.submitList(allCart)
    }

}