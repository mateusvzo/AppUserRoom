package com.example.appuserroom.service.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appuserroom.service.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {
        private lateinit var INSTANCE: UserDataBase

        fun getDataBase(context: Context): UserDataBase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(UserDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, UserDataBase::class.java, "userdb")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM User")
            }

        }

    }
}