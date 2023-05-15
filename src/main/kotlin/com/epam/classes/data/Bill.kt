package com.epam.classes.data

import com.epam.classes.GasStation

/**
 * DTO class which represents an order of our gas station.
 *
 * @param vehicle which client want to fill up
 * @param isDiscountExist is discount exists or not (result of [GasStation.isDiscountExist])
 * @param amountToFill how match liters our client wants to buy
 * @param totalPrice how much client should pay in order to fill up his vehicle
 *   (should be defined on [GasStation.checkAndShowTotalInfo] step)
 */
data class Bill(
    val vehicle: Vehicle,
    val isDiscountExist: Boolean?,
    val amountToFill: Int,
    val totalPrice: Double
)