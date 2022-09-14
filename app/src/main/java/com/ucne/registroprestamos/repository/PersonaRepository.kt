package com.ucne.registroprestamos.repository

import com.ucne.registroprestamos.data.AppDataBase
import com.ucne.registroprestamos.model.Persona

import javax.inject.Inject

class PersonaRepository @Inject constructor(
        val db: AppDataBase
    ){

        suspend fun insertpersona(persona: Persona) {
            db.personaDao.insertpersona(persona)
        }

        suspend fun updatepersona(persona: Persona) {
            db.personaDao.updatepersona(persona)
        }

        suspend fun deletepersona(persona: Persona) {
            db.personaDao.deletepersona(persona)
        }

        fun getOcupacione(id: Int)=db.ocupacioneDao.getOcupacione(id)
        fun getAllPersona() = db.personaDao.getAllPersona()


}