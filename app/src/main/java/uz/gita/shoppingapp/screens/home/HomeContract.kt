package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.entity.HomeItemVertical

interface HomeContract {

    interface Model{
        fun getAllItem(): ArrayList<HomeItemVertical>
    }
    interface View{
        fun showAllItem(homeItemVertical: ArrayList<HomeItemVertical>)
    }
    interface Presenter{

    }


}