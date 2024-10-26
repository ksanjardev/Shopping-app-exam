package uz.gita.shoppingapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.gita.shoppingapp.data.entity.UserDataEntity

@Dao
interface UserDataDao {

    @Query("SELECT EXISTS(SELECT 1 FROM UserDataEntity WHERE nickName = :nickName)")
    fun isUserExist(nickName: String): Boolean

    @Query("SELECT * FROM UserDataEntity WHERE nickName = :nickName")
    fun getUserByNickName(nickName: String): UserDataEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(profile: UserDataEntity)

    @Query("SELECT * FROM UserDataEntity")
    fun getProfile(): List<UserDataEntity>

    @Update
    fun updateProfile(profile: UserDataEntity)
}