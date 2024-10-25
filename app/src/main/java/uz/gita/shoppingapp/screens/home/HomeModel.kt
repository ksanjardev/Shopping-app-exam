package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.HomeItemVertical

class HomeModel:HomeContract.Model {
    private val itemVertical = AppDatabase.instance.homeItemVerticalDao()
    override fun getAllItem(): ArrayList<HomeItemVertical> {
        return itemVertical.getAllItem() as ArrayList
    }
}