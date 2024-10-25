package uz.gita.shoppingapp.screens.favourite

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface FavouriteContract {
    interface Model{
        fun getFavouriteItems(): ArrayList<HomeItemVertical>
        fun removeFavouriteItem(itemVertical: HomeItemVertical)
    }
    interface View{
        fun showFavouriteItems(itemVertical: ArrayList<HomeItemVertical>)
        fun backToHomeScreen()
    }
    interface Presenter{
        fun getFavouriteItems()
        fun backButtonClick()
        fun favouriteItemClick(itemVertical: HomeItemVertical)
    }

}