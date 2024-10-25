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

    @Query("UPDATE HomeItemVertical SET favourite = :favourite WHERE id = :id")
    fun updateFavourite(id: Int, favourite: Int)

    @Query("UPDATE HomeItemVertical SET cart = :cart WHERE id = :id")
    fun updateCart(id: Int, cart: Int)

    @Query("SELECT * FROM HomeItemVertical")
    fun getAllItem(): List<HomeItemVertical>

    @Query("SELECT * FROM HomeItemVertical WHERE favourite = 1")
    fun getFavoriteItems(): List<HomeItemVertical>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun favouriteItemState(itemVertical: HomeItemVertical)
}