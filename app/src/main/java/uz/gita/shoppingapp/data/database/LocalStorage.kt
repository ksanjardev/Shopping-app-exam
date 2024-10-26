package uz.gita.shoppingapp.data.database

import android.content.SharedPreferences

object LocalStorage {
    private lateinit var preferences: SharedPreferences

    private const val SIGN_IN = "is_in"
    private const val USER_PHONE_NUMBER = "user_number"

    fun setSharedPreference(sharedPreferences: SharedPreferences) {
        preferences = sharedPreferences
    }

    fun isUserSignedIn(): Boolean {
        return preferences.getBoolean(SIGN_IN, false)
    }

    fun isUserSignedIn(boolean: Boolean) {
        preferences.edit().putBoolean(SIGN_IN, boolean).apply()
    }

    fun saveCurrentUserPhoneNumber(phoneNumber: String) {
        preferences.edit().putString(USER_PHONE_NUMBER, phoneNumber).apply()
    }

    fun setNickname(nickName: String){
        preferences.edit().putString("nick", nickName).apply()
    }
    fun getNickName(): String{
        return preferences.getString("nick", "").toString()
    }
}