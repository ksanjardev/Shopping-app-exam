package uz.gita.shoppingapp.screens.personal_info

import uz.gita.shoppingapp.data.entity.UserDataEntity

interface PersonalContract {
    interface Model {
        fun getUserData(nickName: String): UserDataEntity?
        fun updateUserData(user: UserDataEntity)
    }

    interface View {
        fun displayUserData(user: UserDataEntity)
        fun showUpdateSuccess()
        fun showUpdateError(error: String)
        fun backToProfile()
    }

    interface Presenter {
        fun loadUserData(nickName: String)
        fun saveButtonClick(user: UserDataEntity)
    }
}