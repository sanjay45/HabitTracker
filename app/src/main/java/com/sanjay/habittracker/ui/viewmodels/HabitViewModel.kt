package com.sanjay.habittracker.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sanjay.habittracker.data.database.HabitDatabase
import com.sanjay.habittracker.data.models.Habit
import com.sanjay.habittracker.logic.dao.HabitDao
import com.sanjay.habittracker.logic.repository.HabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : HabitRepository
    val getAllHabits: LiveData<List<Habit>>

    init {
        val habitDao : HabitDao = HabitDatabase.getDatabase(application).habitDao()
        repository = HabitRepository(habitDao)

        getAllHabits = repository.getAllHabits
    }

    fun addHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHabit(habit)
        }
    }
    fun updateHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateHabit(habit)
        }
    }
    fun deleteHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteHabit(habit)
        }
    }
    fun deleteAllHabits(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllHabits()
        }
    }



}