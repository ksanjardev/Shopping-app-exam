package uz.gita.shoppingapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: String,
    val nickName: String,
    val password: String,
    val phoneNumber: String
)