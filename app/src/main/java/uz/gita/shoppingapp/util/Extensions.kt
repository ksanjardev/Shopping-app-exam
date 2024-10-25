package uz.gita.shoppingapp.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

fun Fragment.goNextScreen(view: View, resId: Int) {
    findNavController(view).navigate(resId)
}