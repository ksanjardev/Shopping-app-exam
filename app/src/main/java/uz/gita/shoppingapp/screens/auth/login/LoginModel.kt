package uz.gita.shoppingapp.screens.auth.login

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.data.entity.UserDataEntity

class LoginModel : LoginContract.Model {

    private val userDao by lazy { AppDatabase.instance.userItem() }

    override fun isUserExists(nickName: String): Boolean {
        return userDao.isUserExist(nickName)
    }

    override fun getUserByData(nickName: String): UserDataEntity {
        return userDao.getUserByNickName(nickName)!!
    }

    override fun saveNickName(nick: String) {
        LocalStorage.setNickname(nick)
    }

}