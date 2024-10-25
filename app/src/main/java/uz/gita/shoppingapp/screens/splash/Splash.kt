package uz.gita.shoppingapp.screens.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.util.goNextScreen

class Splash : Fragment(R.layout.splash_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        object : CountDownTimer(2000, 100) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (LocalStorage.getEnter()) {
                    findNavController().navigate(R.id.action_splash_to_bottomMenu)
                } else {
                    findNavController().navigate(R.id.action_splash_to_registerScreen)
                }
            }

        }.start()
    }
}