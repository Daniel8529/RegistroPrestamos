package com.ucne.registroprestamos.repository

import javax.inject.Inject
import com.ucne.registroprestamos.data.AppDataBase
import com.ucne.registroprestamos.data.dao.OcupacioneDao
import com.ucne.registroprestamos.model.Ocupacione

class ocupacioneRepository @Inject constructor(
    val db: AppDataBase) {

    suspend fun inser(ocupacione: Ocupacione) {
        db.ocupacioneDao.inser(ocupacione)
    }

    suspend fun update(ocupacione: Ocupacione) {
        db.ocupacioneDao.update(ocupacione)
    }

    suspend fun delete(ocupacione: Ocupacione) {
        db.ocupacioneDao.delete(ocupacione)
    }

    fun getOcupacione(id: Int)=db.ocupacioneDao.getOcupacione(id)
    fun getAll() = db.ocupacioneDao.getAll()

}