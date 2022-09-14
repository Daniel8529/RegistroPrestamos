package com.ucne.registroprestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Persona" )
data class Persona(
@PrimaryKey(autoGenerate = true)
val Id: Int=0,
val Nombre: String="",
val Telefono: Int=0,
val Celular: Int=0,
val Email: String="",
val Direccion: String="",
val FechaNacimiento: String="",
val OcupacionId: String="",
)
