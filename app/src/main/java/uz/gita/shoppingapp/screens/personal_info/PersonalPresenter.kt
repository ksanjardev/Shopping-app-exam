package uz.gita.shoppingapp.screens.personal_info

import android.util.Log
import uz.gita.shoppingapp.data.entity.UserDataEntity

class PersonalPresenter(val view: PersonalContract.View) : PersonalContract.Presenter {
    private val model: PersonalContract.Model = PersonalModel()
    override fun loadUserData(nickName: String) {
        val user = model.getUserData(nickName)
        if (user != null) {
            view.displayUserData(user)
        }
    }

    override fun saveButtonClick(user: UserDataEntity) {
        model.updateUserData(user)
        Log.d("Check", "saveButtonClick: ${user.name}")
        view.showUpdateSuccess()
        view.backToProfile()
    }


}