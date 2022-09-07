package com.ucne.registroprestamos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.registroprestamos.model.Ocupacione
import com.ucne.registroprestamos.data.dao.OcupacioneDao

@Database(
    entities = [Ocupacione::class],
    version = 2
)
abstract class AppDataBase : RoomDatabase() {
    abstract val ocupacioneDao:OcupacioneDao
}