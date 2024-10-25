package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface HomeContract {

    interface Model{
        fun getAllItem(): ArrayList<HomeItemVertical>
        fun updateFavouriteData(id: Int, itemVertical: Int)
        fun updateCartData(id: Int, itemVertical: Int)
    }
    interface View{
        fun showAllItem(homeItemVertical: ArrayList<HomeItemVertical>)
        fun showFavouriteScreen()
    }
    interface Presenter{
        fun updateFavouriteData(id:Int, itemVertical: Int)
        fun updateCartData(id: Int, itemVertical: Int)
        fun getAllItem()
        fun  favouriteItemClick()
    }


}