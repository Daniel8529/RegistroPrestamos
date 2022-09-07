package com.ucne.registroprestamos.util

sealed class Screen(val route: String){
    object OcupacioneListScreen: Screen("OcupacioneList")
    object OcupacioneScreen: Screen("Ocupacione")
}