package uz.gita.shoppingapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.data.entity.HomeItemVertical

@Dao
interface CatalogItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItem(catalogItem: CatalogItem)

    @Query("SELECT * FROM CatalogItem")
    fun getAllItem(): List<CatalogItem>
}