package uz.gita.shoppingapp.screens.auth.register

import uz.gita.shoppingapp.data.entity.UserDataEntity

interface RegisterContract {
    interface Model{
        fun isUserExistOrNot(nickName: String): Boolean
        fun insertUser(userDataEntity: UserDataEntity)
        fun saveUserNickName(name: String)
    }
    interface View{
        fun openLogin()
        fun openMainScreen()
        fun showToast(msg: String)
    }
    interface Presenter{
        fun addAccountButtonClick(name: String, age: String, phoneNumber: String, nickName: String, password: String)
        fun loginButtonClick()
        fun saveNickName(name: String)
    }
}