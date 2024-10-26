package uz.gita.shoppingapp.screens.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import uz.gita.shoppingapp.adapters.CartItemAdapter
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

        cartItemAdapter.setCountPlus { id, count ->
            presenter.addButtonClick(id, count)
            showData()
        }

        showData()

        cartItemAdapter.setCountMinus{id, count ->
            presenter.minusButtonClick(id, count)
            showData()
        }

        cartItemAdapter.setLikeState{id, count ->
            presenter.setLikeState(id, count)
            showData()
        }

        binding.payButton.setOnClickListener{
            presenter.buttonPayClick()
            cartItemAdapter.clearList()
            binding.totalProductCount.text = "0"
            binding.totalPrice.text = "0"
            binding.totalProductCount.text = "0"
        }

    }

    private fun showData(){
        cartItemAdapter.submitList(presenter.getAllCartItems() )
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


}