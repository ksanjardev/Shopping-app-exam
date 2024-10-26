package uz.gita.shoppingapp.screens.cart

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface CartContract {
    interface Model{
        fun getAllCart(): List<HomeItemVertical>
        fun setProductCount(data: HomeItemVertical)
        fun setLikeState(data: HomeItemVertical)
        fun setCartState(data:HomeItemVertical)
        fun updateAll()
    }
    interface View{
        fun showBasketProductsSize(size: Int)
        fun showSumPrice(sum: Int)
        fun showTotalProductCount(totalCount: Int)
        fun showToast(msg: String)
        fun setData(allCart: List<HomeItemVertical>)

    }
    interface Presenter{
        fun addButtonClick(data: HomeItemVertical)
        fun minusButtonClick(data: HomeItemVertical)
        fun buttonPayClick()
        fun setLikeState(data: HomeItemVertical)
        fun setData()
        fun setCartState(data: HomeItemVertical)
        fun getAllCartItems(): List<HomeItemVertical>
        fun updateItems()
    }
}