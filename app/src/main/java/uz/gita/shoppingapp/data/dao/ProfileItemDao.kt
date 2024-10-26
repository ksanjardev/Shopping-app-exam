package uz.gita.shoppingapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.gita.shoppingapp.data.entity.ProfileItemEntity

@Dao
interface ProfileItemDao {

    @Query("SELECT * FROM ProfileItemEntity")
    fun getAllItem(): List<ProfileItemEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItem(profileItem:ProfileItemEntity)
}