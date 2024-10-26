package uz.gita.shoppingapp.screens.auth.login

import uz.gita.shoppingapp.data.database.LocalStorage
import java.util.prefs.Preferences


class LoginPresenter(val view: LoginContract.View): LoginContract.Presenter {
    private val model: LoginContract.Model = LoginModel()
    override fun nextButtonClick(nickName: String, password: String) {
        if (nickName.isEmpty() || password.isEmpty()) {
            view.showToast("To'ldiring!")
            return
        }
        if (!model.isUserExists(nickName)) {
            view.showToast("Bu raqamdagi akkaunt topilmadi. Ro'yxatdan o'ting!")
            return
        }

        if (model.getUserByData(nickName).password != password) {
            view.showToast("Password Incorrect")
            return
        }

        // everything correct
        LocalStorage.saveCurrentUserPhoneNumber(nickName)
        LocalStorage.isUserSignedIn(true)

        view.openMainScreen()

    }

    override fun btnRegisterClicked() {
        view.openRegisterScreen()
    }

    override fun saveNickName(nick: String) {
        model.saveNickName(nick)
    }

}