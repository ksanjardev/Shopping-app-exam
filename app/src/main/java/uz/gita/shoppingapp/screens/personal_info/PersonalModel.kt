package uz.gita.shoppingapp.screens.personal_info

import android.util.Log
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.UserDataEntity

class PersonalModel: PersonalContract.Model {
    private val userDataDao = AppDatabase.instance.userItem()

    override fun getUserData(nickName: String): UserDataEntity? {
        return userDataDao.getUserByNickName(nickName)
    }

    override fun updateUserData(user: UserDataEntity) {
        Log.d("chch", "updateUserData: ${user.name}")
        userDataDao.updateProfile(user)
    }

}