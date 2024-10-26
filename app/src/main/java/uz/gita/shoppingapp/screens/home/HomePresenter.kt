package uz.gita.shoppingapp.screens.home

import uz.gita.shoppingapp.data.entity.HomeItemVertical

class HomePresenter(val view: HomeContract.View) : HomeContract.Presenter {
    private val model: HomeContract.Model = HomeModel()
    override fun updateFavouriteData(id: Int, itemVertical: Int) {
        model.updateFavouriteData(id, itemVertical)
    }

    override fun updateCartData(data: HomeItemVertical) {
        model.updateCartData(data)
//        view.showToast(id, itemVertical)
    }

    override fun getAllItem() {
        view.showAllItem(model.getAllItem())
    }

    override fun favouriteItemClick() {
        view.showFavouriteScreen()
    }

}