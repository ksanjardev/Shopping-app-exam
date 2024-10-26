package uz.gita.shoppingapp.screens.profile

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.ProfileItemEntity

class ProfileModel: ProfileContract.Model {
    private val profileItemDao = AppDatabase.instance.profileItem()
    override fun getAllItem(): List<ProfileItemEntity> {
        return profileItemDao.getAllItem()
    }
}