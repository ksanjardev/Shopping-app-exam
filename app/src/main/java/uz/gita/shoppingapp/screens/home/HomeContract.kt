package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface HomeContract {

    interface Model {
        fun getAllItem(): ArrayList<HomeItemVertical>
        fun updateFavouriteData(id: Int, itemVertical: Int)
        fun updateCartData(data: HomeItemVertical)
    }

    interface View {
        fun showAllItem(homeItemVertical: ArrayList<HomeItemVertical>)
        fun showFavouriteScreen()
        fun showToast(id: Int, cartCount: Int)
    }

    interface Presenter {
        fun updateFavouriteData(id: Int, itemVertical: Int)
        fun updateCartData(data: HomeItemVertical)
        fun getAllItem()
        fun favouriteItemClick()
    }


}