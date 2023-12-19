package com.yeditepe.weekthreesectiontwo.weektwelve.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyColor::class], version = 1)
abstract class ColorDatabase: RoomDatabase() {
    abstract fun getMyCalorDAO(): MyColorDAO

    companion object {
        @Volatile
        private var INSTANCE: ColorDatabase? = null
        fun getInstance(context: Context): ColorDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ColorDatabase::class.java, "color_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }


        }
    }
}