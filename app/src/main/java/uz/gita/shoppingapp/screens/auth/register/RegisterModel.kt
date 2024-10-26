package uz.gita.shoppingapp.screens.auth.register

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.data.entity.UserDataEntity

class RegisterModel : RegisterContract.Model {
    private val userDao = AppDatabase.instance.userItem()

    override fun isUserExistOrNot(nickName: String): Boolean {
        return userDao.isUserExist(nickName)
    }

    override fun insertUser(userDataEntity: UserDataEntity) {
        userDao.insertUser(userDataEntity)
    }

    override fun saveUserNickName(name: String) {
        LocalStorage.setNickname(name)
    }

}