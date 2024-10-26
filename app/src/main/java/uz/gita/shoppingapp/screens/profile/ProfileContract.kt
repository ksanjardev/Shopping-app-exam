package uz.gita.shoppingapp.screens.profile

import uz.gita.shoppingapp.data.entity.ProfileItemEntity

interface ProfileContract {
    interface Model{
        fun getAllItem(): List<ProfileItemEntity>
    }
    interface View{
        fun showAllItem(items: List<ProfileItemEntity>)
        fun showToast(msg: String)
        fun showPersonalInfoScreen()
        fun backToRegister()
        fun showLogOutDialog()
    }
    interface Presenter{
        fun getAllItem()
        fun showMessage()
        fun editProfileButtonClick()
        fun logOutButtonClick()
        fun dialogYesButtonClick()
    }
}