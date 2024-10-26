package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface HomeContract {

    interface Model {
        fun getAllItem(): ArrayList<HomeItemVertical>
        fun updateFavouriteData(id: Int, itemVertical: Int)
        fun updateCartData(data: HomeItemVertical)
        fun getSearchWords(name: String) : List<HomeItemVertical>
    }

    interface View {
        fun showAllItem(homeItemVertical: List<HomeItemVertical>)
        fun showFavouriteScreen()
        fun showToast(id: Int, cartCount: Int)
    }

    interface Presenter {
        fun updateFavouriteData(id: Int, itemVertical: Int)
        fun updateCartData(data: HomeItemVertical)
        fun getAllItem()
        fun favouriteItemClick()
        fun getSearchWords(name: String)
    }


}