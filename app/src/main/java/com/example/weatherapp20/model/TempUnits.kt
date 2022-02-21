package com.example.weatherapp20.model

interface TempUnits {
    val name: String
    val type: String
}

data class Fahrenheit(override val name: String = FAHRENHIET, override val type: String = FAHRENHIET_UNITS):
    TempUnits

data class Celsius(override val name: String = CELSIUS, override val type: String = CELSIUS_UNITS):
    TempUnits
