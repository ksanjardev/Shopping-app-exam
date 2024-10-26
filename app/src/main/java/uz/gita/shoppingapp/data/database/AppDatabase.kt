package uz.gita.shoppingapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.shoppingapp.data.dao.CatalogItemDao
import uz.gita.shoppingapp.data.dao.HomeItemVerticalDao
import uz.gita.shoppingapp.data.dao.ProfileItemDao
import uz.gita.shoppingapp.data.dao.UserDataDao
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.data.entity.HomeItemVertical
import uz.gita.shoppingapp.data.entity.ProfileItemEntity
import uz.gita.shoppingapp.data.entity.UserDataEntity

@Database(entities = [HomeItemVertical::class, CatalogItem::class, ProfileItemEntity::class, UserDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun homeItemVerticalDao(): HomeItemVerticalDao
    abstract fun catalogItem(): CatalogItemDao
    abstract fun profileItem(): ProfileItemDao
    abstract fun userItem(): UserDataDao

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