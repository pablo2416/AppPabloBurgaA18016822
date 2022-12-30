package com.idat.edu.apppabloburgaa18016822.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.idat.edu.apppabloburgaa18016822.data.database.model.PacienteEntity

@Dao
interface PacienteDao {
    @Query("SELECT * FROM paciente_table")
    fun getAllPacientes(): List<PacienteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaciente(pacienteEntity: PacienteEntity)

    @Query("DELETE FROM paciente_table")
    suspend fun deleteAllPaciente()
}