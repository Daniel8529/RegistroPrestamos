package com.ucne.registroprestamos.data.dao

import kotlinx.coroutines.flow.Flow
import androidx.room.*
import com.ucne.registroprestamos.model.Ocupacione


@Dao
interface OcupacioneDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun inser(ocupacione: Ocupacione)

    @Update
    suspend fun update(ocupacione: Ocupacione)

    @Delete
    suspend fun delete(ocupaciones:Ocupacione)

    @Query("SELECT * "+ "FROM Ocupacione"+" WHERE Id = :id")

    fun getOcupacione(id: Int): Flow<Ocupacione>

    @Query("SELECT * FROM Ocupacione")
    fun getAll(): Flow<List<Ocupacione>>
}
