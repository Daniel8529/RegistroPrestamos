package com.ucne.registroprestamos.data.dao

import androidx.room.*
import com.ucne.registroprestamos.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert
    suspend fun insertpersona(persona: Persona)

    @Update
    suspend fun updatepersona(persona: Persona)

    @Delete
    suspend fun deletepersona(persona: Persona)

    @Query("SELECT * FROM Persona WHERE Id = :id")

    fun getPersona(id: Int): Flow<Persona>

    @Query("SELECT * FROM Persona")
    fun getAllPersona(): Flow<List<Persona>>
}