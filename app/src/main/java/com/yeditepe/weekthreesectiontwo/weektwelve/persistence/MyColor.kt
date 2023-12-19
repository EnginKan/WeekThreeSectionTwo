package com.yeditepe.weekthreesectiontwo.weektwelve.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "color_table")
data class MyColor(
    @PrimaryKey(autoGenerate = true) val _id: Int,
    @ColumnInfo(name="hex") val hex_code:String,
    val name: String

)
