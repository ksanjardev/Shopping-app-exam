package uz.gita.shoppingapp.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.shoppingapp.data.dao.HomeItemVerticalDao

abstract class AppDatabase : RoomDatabase(){
    abstract fun homeItemVerticalDao(): HomeItemVerticalDao

    companion object{
        lateinit var instance: AppDatabase
        fun init(context: Context){
            if (!(::instance.isInitialized))
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "ItemVertical.db")
                    .allowMainThreadQueries()
                    .build()
        }
    }
}