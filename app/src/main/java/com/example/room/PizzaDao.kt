package com.example.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizza")
    fun getAllPiza():List<Pizza>
    @Query("SELECT * FROM pizza WHERE id = :id")
    fun getPizaById(id:Int):Pizza
    @Insert
    fun unserPizza(pizza: Pizza)
    @Delete
    fun Delete(pizza: Pizza)
}