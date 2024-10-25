package uz.gita.shoppingapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeItemVertical(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: Int,
    val itemDescription: String,
    val oldPrice: Int,
    val newPrice: Int,
    val monthlyPayment: Int,
    var favourite: Int,
    var cart: Int
)