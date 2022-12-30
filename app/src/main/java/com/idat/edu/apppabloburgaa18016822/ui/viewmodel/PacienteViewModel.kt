package com.idat.edu.apppabloburgaa18016822.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.idat.edu.apppabloburgaa18016822.data.database.PacienteDatabase
import com.idat.edu.apppabloburgaa18016822.data.database.model.PacienteEntity
import kotlinx.coroutines.launch

class PacienteViewModel : ViewModel() {

    private lateinit var database: PacienteDatabase

    fun onCreate(context: Context) {
        database =
            Room.databaseBuilder(context, PacienteDatabase::class.java, "paciente_database").build()
        viewModelScope.launch {
            database.getPacienteDao().deleteAllPaciente()
        }
    }

    fun insertPaciente(pacienteEntity: PacienteEntity) {
        viewModelScope.launch {
            database.getPacienteDao().insertPaciente(pacienteEntity)
        }
    }
}