package com.ucne.registroprestamos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ucne.registroprestamos.model.Ocupacione
import com.ucne.registroprestamos.data.dao.OcupacioneDao
import com.ucne.registroprestamos.data.dao.PersonaDao
import com.ucne.registroprestamos.model.Persona

@Database(
    entities = [Ocupacione::class, Persona::class],
    version = 2,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract val ocupacioneDao:OcupacioneDao
    abstract val personaDao:PersonaDao
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}