package uz.gita.shoppingapp.screens.favourite

import android.util.Log
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.HomeItemVertical

class FavouriteModel: FavouriteContract.Model {
    private val favouriteItems = AppDatabase.instance.homeItemVerticalDao()

    override fun getFavouriteItems(): ArrayList<HomeItemVertical> {
        return favouriteItems.getFavoriteItems() as ArrayList
    }

    override fun removeFavouriteItem(itemVertical: HomeItemVertical) {
        favouriteItems.favouriteItemState(itemVertical)
    }

}