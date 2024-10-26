package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.HomeItemVertical

class HomeModel:HomeContract.Model {
    private val itemVertical = AppDatabase.instance.homeItemVerticalDao()
    override fun getAllItem(): ArrayList<HomeItemVertical> {
        return itemVertical.getAllItem() as ArrayList
    }

    override fun updateFavouriteData(id: Int, itemVertical: Int) {
        this.itemVertical.updateFavourite(id, itemVertical)
    }

    override fun updateCartData(data: HomeItemVertical) {
        this.itemVertical.updateProductCount(data.copy(cart = 1, countItem = 1))
    }
}