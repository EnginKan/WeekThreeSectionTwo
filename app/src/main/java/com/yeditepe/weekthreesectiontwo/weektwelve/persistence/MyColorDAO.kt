package com.yeditepe.weekthreesectiontwo.weektwelve.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyColorDAO {

    @Query("Select * from color_table")
    suspend fun getAll(): List<MyColor>

    @Insert
    suspend fun insertColor(color: MyColor): Unit

    @Delete
    suspend fun deleteColor(color: MyColor): Unit

    @Update
    suspend fun updateColor(color: MyColor): Unit

    @Query("Select * from color_table where name like :str")
    fun getAllByGivenName(str: String): List<MyColor>

    @Query("Select * from color_table where _id=:id")
    suspend fun getColorByID(id: Int): MyColor
}