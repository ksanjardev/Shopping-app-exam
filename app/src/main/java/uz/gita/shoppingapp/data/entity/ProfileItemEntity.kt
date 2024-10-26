package uz.gita.shoppingapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProfileItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val icon: Int,
    val iconText: String
)