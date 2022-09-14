package com.ucne.registroprestamos.util

sealed class Screen(val route: String){
    object OcupacioneListScreen: Screen("OcupacioneList")
    object OcupacioneScreen: Screen("Ocupacione")
    object PersonaScreen: Screen("Persona")
    object PersonaListScreen : Screen("PersonaList")
    object Menu: Screen("Menu")

}