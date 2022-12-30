package com.idat.edu.apppabloburgaa18016822.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paciente_table")
data class PacienteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "nombre_apellido") var nombreapellido: String,
    @ColumnInfo(name = "celular") var celular: String,
)