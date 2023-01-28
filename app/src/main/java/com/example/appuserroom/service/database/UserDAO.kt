package com.example.appuserroom.service.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appuserroom.service.model.UserModel

@Dao
interface UserDAO {

    @Insert
    fun insert(user: UserModel): Long

    @Update
    fun update(user: UserModel): Int

    @Delete
    fun delete(user: UserModel)

    @Query("SELECT * FROM User")
    fun get(): List<UserModel>
}