package uz.gita.shoppingapp.screens.profile

import uz.gita.shoppingapp.data.dao.ProfileItemDao
import uz.gita.shoppingapp.data.entity.ProfileItemEntity

class ProfilePresenter(val view: ProfileContract.View): ProfileContract.Presenter {
    private val model: ProfileContract.Model = ProfileModel()
    override fun getAllItem() {
        view.showAllItem(model.getAllItem())
    }

    override fun showMessage() {
        view.showToast("In Progress!!")
    }

    override fun editProfileButtonClick() {
        view.showPersonalInfoScreen()
    }

    override fun logOutButtonClick() {
        view.showLogOutDialog()
    }

    override fun dialogYesButtonClick() {
        view.backToRegister()
    }

}