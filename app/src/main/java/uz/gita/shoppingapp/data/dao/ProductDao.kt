package uz.gita.shoppingapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.shoppingapp.data.entity.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM ProductEntity")
    fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM ProductEntity WHERE categoryId = :id")
    fun getProductsByCategoryId(id: Int): List<ProductEntity>



}