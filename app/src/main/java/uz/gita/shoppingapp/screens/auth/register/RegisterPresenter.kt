package uz.gita.shoppingapp.screens.auth.register

import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.data.entity.UserDataEntity

class RegisterPresenter(val view: RegisterContract.View) : RegisterContract.Presenter {
    private val model: RegisterContract.Model = RegisterModel()

    override fun addAccountButtonClick(
        name: String,
        age: String,
        phoneNumber: String,
        nickName: String,
        password: String
    ) {
        if (name.isEmpty() || age.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || nickName.isEmpty()) {
            view.showToast("To'ldiring!")
            return
        }

        if (model.isUserExistOrNot(phoneNumber)) {
            view.showToast("Bu raqam oldin ro'yxatdan o'tgan!")
            return
        }

        model.insertUser(
            UserDataEntity(
                0,
                name = name,
                age = age,
                phoneNumber = phoneNumber,
                nickName = nickName,
                password = password
            )
        )

        view.openMainScreen()
        LocalStorage.isUserSignedIn(true)
    }

    override fun loginButtonClick() {
        view.openLogin()
    }

    override fun saveNickName(name: String) {
        model.saveUserNickName(name)
    }


}