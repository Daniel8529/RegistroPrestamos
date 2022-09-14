package com.ucne.registroprestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ocupacione" )
data class Ocupacione(
    @PrimaryKey(autoGenerate = true)
    val Id: Int=0,
    val Descripcion: String="",
    val Sueldo: Float=0f
)