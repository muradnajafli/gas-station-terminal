package com.epam.classes.data

sealed class Fuel(val costPerLiter: Int = 0, val discountValue: Int = 0)

/**
 * All these classes should be inherited from com.epam.classes.data.Fuel class
 */
data class Diesel(
    val cost: Int = 2,
    val discount: Int = 5
)

data class Petrol(
    val cost: Int = 3,
    val discount: Int = 7
)

object NonFuel
