package com.idat.edu.apppabloburgaa18016822.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.idat.edu.apppabloburgaa18016822.data.database.dao.PacienteDao
import com.idat.edu.apppabloburgaa18016822.data.database.model.PacienteEntity

@Database(entities = [PacienteEntity::class], version = 1)
abstract class PacienteDatabase: RoomDatabase() {
    abstract fun getPacienteDao(): PacienteDao
}