package uz.gita.shoppingapp.screens.cart

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface CartContract {
    interface Model{
        fun getAllCart(): List<HomeItemVertical>
        fun setProductCount(id: Int, count: Int)
        fun setLikeState(id: Int, newState: Int)
        fun setCartState(id: Int, newState: Int)
    }
    interface View{
        fun showBasketProductsSize(size: Int)
        fun showSumPrice(sum: Int)
        fun showTotalProductCount(totalCount: Int)
        fun showToast(msg: String)
    }
    interface Presenter{
        fun addButtonClick(id: Int, count: Int)
        fun minusButtonClick(id: Int, count: Int)
        fun buttonPayClick()
        fun setLikeState(id: Int, newState: Int)
        fun setData()
        fun getAllCartItems(): List<HomeItemVertical>
    }
}