package uz.gita.shoppingapp.screens.home

class HomePresenter(val view: HomeContract.View):HomeContract.Presenter {
    private val model: HomeContract.Model = HomeModel()
}