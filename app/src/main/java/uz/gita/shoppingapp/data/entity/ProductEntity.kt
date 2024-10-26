package uz.gita.shoppingapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CatalogItem::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("categoryId")
        )
    ]
)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val categoryId: Int,
    val productName: String,
    val productDescription: String,
    val oldPrice: String,
    val newPrice: String,
    val image: Int,
    val isDefault: Int = 0,
    var isFavourite: Int = 0,
    var imageUri: String = ""
)