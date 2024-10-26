package uz.gita.shoppingapp.screens.cart

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.HomeItemVertical

class CartModel : CartContract.Model {
    private val cartItems = AppDatabase.instance.homeItemVerticalDao()
    override fun getAllCart(): List<HomeItemVertical> {
        return cartItems.getCartItems()
    }

    override fun setProductCount(data: HomeItemVertical) {
        cartItems.updateProductCount(data)
    }

    override fun setLikeState(data: HomeItemVertical) {
        cartItems.favouriteItemState(data)
    }

    override fun setCartState(data: HomeItemVertical) {
        cartItems.updateProductCount(data)
//        cartItems.cartItemState(data)
    }

    override fun updateAll() {
        cartItems.getCartItems().forEach { data->
            cartItems.updateProductCount(data.copy(cart =  0, countItem = 0))
        }
    }
}