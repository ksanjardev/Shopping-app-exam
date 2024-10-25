package uz.gita.shoppingapp.data.database

import android.content.SharedPreferences

object LocalStorage {
    private lateinit var sharedPreferences: SharedPreferences
    private const val IS_FIRST_TIME = "user first enter"
    private const val FULL_NAME = "full name"
    private const val PHONE_NUMBER = "phone number"
    private const val NICK_NAME = "nick name"
    private const val PASSWORD = "password"

    fun setSharedPreference(sharedPreferences: SharedPreferences){
        this.sharedPreferences = sharedPreferences
    }

    fun setEnter(bool: Boolean){
        sharedPreferences.edit().putBoolean(IS_FIRST_TIME, bool).apply()
    }

    fun getEnter(): Boolean{
        return sharedPreferences.getBoolean(IS_FIRST_TIME, false)
    }
    fun setName(name: String){
        sharedPreferences.edit().putString(FULL_NAME, name).apply()
    }
    fun getName(): String?{
        return sharedPreferences.getString(FULL_NAME, "")
    }
    fun setPhoneNumber(phone: String){
        sharedPreferences.edit().putString(PHONE_NUMBER, phone).apply()
    }
    fun getPhoneNumber(): String?{
        return sharedPreferences.getString(PHONE_NUMBER, "")
    }
    fun setUserName(nickName: String){
        sharedPreferences.edit().putString(NICK_NAME, nickName).apply()
    }
    fun getUserName(): String?{
        return sharedPreferences.getString(NICK_NAME, "")
    }
    fun setPassword(password: String){
        sharedPreferences.edit().putString(PASSWORD, password).apply()
    }
    fun getPassword(): String?{
        return sharedPreferences.getString(PASSWORD, "")
    }
}