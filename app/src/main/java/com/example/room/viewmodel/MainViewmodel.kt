package com.example.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.room.DataBase
import com.example.room.Pizza
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewmodel(val app: Application) : AndroidViewModel(app) {
    private val dataBase = DataBase.getInstance(app).pizzaDao()

    val getPizzaList = MutableLiveData<List<Pizza>>()

    fun list() = viewModelScope.launch(Dispatchers.IO) {
        val allPizza = dataBase.getAllPiza()
        getPizzaList.postValue(allPizza)
    }

    fun delete(pizza: Pizza) = viewModelScope.launch(Dispatchers.IO){
        dataBase.Delete(pizza)

    }



    fun insertNewData(name:String,price:String,img:String)= viewModelScope.launch(Dispatchers.IO) {
        dataBase.unserPizza(Pizza(0,name, price,img))
    }
}