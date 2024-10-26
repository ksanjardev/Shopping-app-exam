package uz.gita.shoppingapp.screens.cart

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.HomeItemVertical

class CartModel : CartContract.Model {
    private val cartItems = AppDatabase.instance.homeItemVerticalDao()
    override fun getAllCart(): List<HomeItemVertical> {
        return cartItems.getCartItems()
    }

    override fun setProductCount(id: Int, count: Int) {
        cartItems.updateProductCount(id, count)
    }

    override fun setLikeState(id: Int, newState: Int) {
        cartItems.updateFavourite(id, newState)
    }

    override fun setCartState(id: Int, newState: Int) {
        cartItems.updateCart(id, newState)
    }

}