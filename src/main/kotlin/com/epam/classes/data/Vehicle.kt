package com.epam.classes.data

sealed class Vehicle(val fuel: Fuel = NonFuel, val tankVolume: Int = 0)
/**
 * All these classes should be inherited from com.epam.classes.data.Vehicle class
 * and 'petrol' and 'diesel' fields must have default values
 * (instances of classes with default values of properties)
 */
data class Bike(
    val petrol: Petrol,
    val volume: Int = 15,
)

data class Car(
    val petrol: Petrol,
    val volume: Int = 70,
)

data class Bus(
    val diesel: Diesel,
    val volume: Int = 300
)

data class Truck(
    val diesel: Diesel,
    val volume: Int = 800
)

object NonVehicle
