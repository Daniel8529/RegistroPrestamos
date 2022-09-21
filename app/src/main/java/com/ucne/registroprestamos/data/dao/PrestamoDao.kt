package com.ucne.registroprestamos.data.dao

import androidx.room.*
import com.ucne.registroprestamos.model.Prestamo
import kotlinx.coroutines.flow.Flow
@Dao
interface PrestamoDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertprestamo(prestamo: Prestamo)

    @Update
    suspend fun updateprestamo(prestamo: Prestamo)

    @Delete
    suspend fun deleteprestamo(prestamo: Prestamo)

    @Query("SELECT * "+"FROM Prestamo"+" WHERE PrestamoId = :id")

    fun getPrestamo(id: Int): Flow<Prestamo>

    @Query("SELECT * FROM Prestamo")
    fun getAllPrestamo(): Flow<List<Prestamo>>
}