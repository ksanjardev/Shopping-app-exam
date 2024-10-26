package uz.gita.shoppingapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class CatalogItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo var icon: Int,
    @ColumnInfo val iconText: String
):Serializable