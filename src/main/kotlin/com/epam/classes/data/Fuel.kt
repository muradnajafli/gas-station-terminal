package com.epam.classes.data

/**
 * Represents a super class for all possible fuels
 *
 * @property cost presents cost per liter
 * @property discount represents discount pet liter in percentages
 *                    for example, 5 means 5%
 */
sealed class Fuel {
    abstract val cost: Int
    abstract val discount: Int
}

/**
 * Here are all required types of fuel to use in the task
 *
 * Requirements:
 * - all of them should be inherited from [Fuel] class
 * Tips:
 * - in case of [NonFuel] since it's an object you should
 *   override all abstract properties in the body of the class
 */
data class Diesel(
    val cost: Int = 2,
    val discount: Int = 5
)

data class Petrol(
    val cost: Int = 3,
    val discount: Int = 10
)

object NonFuel
