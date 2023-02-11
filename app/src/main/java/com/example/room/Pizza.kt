package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza")
data class Pizza (
     @PrimaryKey    val id:Int,
     @ColumnInfo    val name:String,
     @ColumnInfo    val price:Int
        )