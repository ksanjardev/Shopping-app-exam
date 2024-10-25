package uz.gita.shoppingapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeItemVertical(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)