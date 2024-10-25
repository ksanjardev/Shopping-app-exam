package uz.gita.shoppingapp.screens.favourite

import uz.gita.shoppingapp.data.entity.HomeItemVertical

class FavouritePresenter(val view: FavouriteContract.View):FavouriteContract.Presenter {
    private val model: FavouriteContract.Model = FavouriteModel()
    override fun getFavouriteItems(){
        view.showFavouriteItems(model.getFavouriteItems())
    }

    override fun backButtonClick() {
        view.backToHomeScreen()
    }

    override fun favouriteItemClick(itemVertical: HomeItemVertical) {
        model.removeFavouriteItem(itemVertical.copy(favourite = 0))

    }

}