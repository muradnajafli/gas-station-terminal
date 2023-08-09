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
    val fuel: Fuel = NonFuel,
    val volume: Int = 0
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
class Bike: Vehicle(fuel = Petrol(), volume = 15) {
    override fun toString(): String {
        return "Bike"}
}

class Car : Vehicle(fuel = Petrol(), volume = 70) {
    override fun toString(): String {
        return "Car"
    }
}

class Bus : Vehicle(fuel = Diesel(), volume = 300) {
    override fun toString(): String {
        return "Bus"
    }
}

class Truck : Vehicle(fuel = Diesel(), volume = 800) {
    override fun toString(): String {
        return "Truck"
    }
}

object NonVehicle: Vehicle()
