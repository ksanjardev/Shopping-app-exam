package uz.gita.shoppingapp.app

import android.app.Application
import uz.gita.shoppingapp.data.database.LocalStorage

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.setSharedPreference(getSharedPreferences("Manager", MODE_PRIVATE))
    }
}