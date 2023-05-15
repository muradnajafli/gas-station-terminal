package com.epam.classes.data

/**
 * Represents a super class for available vehicles
 *
 * Requirements:
 * - super class should have default vales for its property
 * Tips:
 * - [NonFuel] type is suitable to be a default fuel
 */
sealed class Vehicle(
    val fuel: Fuel = TODO(),
    val volume: Int = TODO()
)

/**
 * Here are all required types of vehicle to use in the task
 *
 * Requirements:
 * - all of them should be inherited from [Vehicle] class
 * - function `toString()` should return simple name: Bike, Car and e.t.c.
 * - [fuel] fields in every vehicle should have default values
 * Tips:
 * - in case of [NonVehicle] since it's an object you can use
 *  *default values* in super class
 */
class Bike(
    fuel: Petrol,
    volume: Int = 15,
)

class Car(
    fuel: Petrol,
    volume: Int = 70,
)

class Bus(
    fuel: Diesel,
    volume: Int = 300
)

class Truck(
    fuel: Diesel,
    volume: Int = 800
)

object NonVehicle
