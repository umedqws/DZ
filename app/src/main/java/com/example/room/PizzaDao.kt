package com.example.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizza")
    fun getAllPiza():List<Pizza>
    @Query("SELECT * FROM pizza WHERE id = :id")
    fun getPizaById(id:Int):Pizza
    @Query("SELECT id FROM pizza")
    fun getIdPizza():Int
    @Insert
    fun unserPizza(pizza: Pizza)
    @Delete
    fun Delete(pizza: Pizza)

}