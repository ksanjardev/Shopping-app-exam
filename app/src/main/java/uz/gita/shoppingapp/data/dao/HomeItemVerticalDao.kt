package uz.gita.shoppingapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.gita.shoppingapp.data.entity.HomeItemVertical

@Dao
interface HomeItemVerticalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItem(homeItemVertical: HomeItemVertical)

    @Update
    fun updateFavourite(homeItemVertical: HomeItemVertical)

    @Query("SELECT * FROM HomeItemVertical")
    fun getAllItem(): List<HomeItemVertical>

}