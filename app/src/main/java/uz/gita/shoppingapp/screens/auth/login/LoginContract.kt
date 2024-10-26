package uz.gita.shoppingapp.screens.auth.login

import uz.gita.shoppingapp.data.entity.UserDataEntity

interface LoginContract {
    interface Model{
        fun isUserExists(nickName:String):Boolean
        fun getUserByData(nickName: String): UserDataEntity
        fun saveNickName(nick:String)
    }
    interface View{
        fun showToast(message: String)
        fun openRegisterScreen()
        fun openMainScreen()

    }
    interface Presenter{
        fun nextButtonClick(nickName: String, password: String)
        fun btnRegisterClicked()
        fun saveNickName(nick:String)
    }
}