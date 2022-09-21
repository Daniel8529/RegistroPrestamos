package com.ucne.registroprestamos.repository

import com.ucne.registroprestamos.data.AppDataBase
import com.ucne.registroprestamos.model.Prestamo
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val db: AppDataBase
){

    suspend fun insertprestamo(prestamo: Prestamo) {
        db.prestamoDao.insertprestamo(prestamo)
    }

    suspend fun updateprestamo(prestamo: Prestamo) {
        db.prestamoDao.updateprestamo(prestamo)
    }

    suspend fun deleteprestamo(prestamo: Prestamo) {
        db.prestamoDao.deleteprestamo(prestamo)
    }

    fun getPrestamo(id: Int)=db.prestamoDao.getPrestamo(id)
    fun getAllPrestamo() = db.prestamoDao.getAllPrestamo()

}