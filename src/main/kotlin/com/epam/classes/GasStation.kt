package com.epam.classes

import com.epam.classes.Const.BIKE
import com.epam.classes.Const.BUS
import com.epam.classes.Const.CAR
import com.epam.classes.Const.NO
import com.epam.classes.Const.TRUCK
import com.epam.classes.Const.YES
import com.epam.classes.data.Vehicle
import com.epam.classes.mapper.DiscountAvailabilityMapper
import com.epam.classes.mapper.VehicleMapper
import com.epam.classes.data.Fuel
import com.epam.classes.data.NonVehicle

class GasStation {

    /**
     * Requirements:
     * - initialize 'vehicleMapper' and 'discountAvailabilityMapper' here
     *   and make it private
     */
    val vehicleMapper: VehicleMapper = TODO()
    val discountAvailabilityMapper: DiscountAvailabilityMapper = TODO()

    fun fillTank() {
        val vehicle = selectVehicle()
        val isDiscountExist = isDiscountExist()
        println("How much fuel do you want to fill?")
        checkAndShowTotalPrice(vehicle, isDiscountExist, readLine())
    }

    /**
     * Converts user input into [Vehicle] by using [vehicleMapper] and
     * shows appropriate message. Valid inputs are: "bike", "car", "bus" or "truck"
     *
     * Requirements:
     * - when vehicle is valid, it should be returned with the message:
     *   "Your vehicle is {selectedVehicle.toString()}"
     * - when vehicle is not valid ([NonVehicle]), then we have to ask user
     *   to enter vehicle name until it will be valid and show the message:
     *   "Please select one of available vehicles: bike, car, bus or truck"
     * Tips:
     * - you have all vehicle names as constants in the [Const] class
     * - please notice that user input could be null
     * - recursion could help you to satisfy *until it will be valid* requirement
     *
     * @param vehicleName represents user input with selected vehicle
     * @return appropriate vehicle based on user input
     */
    fun getCustomerVehicle(vehicleName: String?): Vehicle {
        TODO()
    }

    /**
     * Checks discount availability by using [discountAvailabilityMapper] and
     * shows appropriate message. Valid inputs are "yes" or "no"
     *
     * Requirements:
     * - when [answerAboutDiscount] is valid, appropriate boolean value should be returned
     * - when [answerAboutDiscount] is not valid, we should ask user to enter discount availability
     *   once again until it will be valid and show the message:
     *   "Please enter "yes" or "no""
     * - when discount is exists, used should see a message: "Discount exist"
     * - when discount isn't exists, used should see a message: "Discount doesn't exist"
     * Tips:
     * - try to use 'when' operator instead of 'if'
     * - you have all discount inputs as constants in the [Const] class
     * - please notice that user input could be null
     * - recursion could help you to satisfy *until it will be valid* requirement
     *
     * @param answerAboutDiscount represents user input with discount availability
     * @return is discount available or not
     */
    fun checkAndReturnIsDiscountAvailable(answerAboutDiscount: String?): Boolean? {
        TODO()
    }

    /**
     * Calculates total price and shows it to the user.
     *
     * Requirements:
     * - if [volumeString] contains incorrect value that **cannot be cast to Int** or
     *   **it's greater than vehicle tank volume** then ask user to enter amount of liters
     *   until it will be valid
     * - successful case should have output:
     *   "Bill: $totalPrice"
     * - unsuccessful case should have output:
     *   "Please enter correct value (not bigger than your tank volume: 500 liters)",
     *   where 500 is [Vehicle.volume]
     * Tips:
     * - total price we can calculate using [calculateTotalPrice]
     * - please notice that user input could be null
     * - recursion could help you to satisfy *until it will be valid* requirement
     *
     * @param volumeString represents user input with amount of liters that customer wants to fill
     * @param vehicle which we need to fill
     * @param isDiscountExist is discount exists or not (result of [GasStation.isDiscountExist])
     */
    fun checkAndShowTotalPrice(vehicle: Vehicle, isDiscountExist: Boolean?, volumeString: String?) {
        //TODO()
    }

    /**
     * Calculates total price which should be spent to fill a vehicle tank, based
     * on the [Fuel.cost] and [Fuel.discount], if [isDiscountExist] == true
     *
     * Tips:
     * - please, keep in mind that [Fuel.discount] represents in percentages
     *
     * @param fuelValue amount of liters that customers want to fill
     * @param vehicle which we need to fill
     * @param isDiscountExist is discount exists or not (result of [GasStation.isDiscountExist])
     * @return total price based on the required fuel
     */
    fun calculateTotalPrice(fuelValue: Int, vehicle: Vehicle, isDiscountExist: Boolean?): Double {
        TODO()
    }

    private fun isDiscountExist(): Boolean? {
        println("Do you have a discount card? ($YES or $NO)")
        return checkAndReturnIsDiscountAvailable(readLine())
    }

    private fun selectVehicle(): Vehicle {
        println("Please choose your vehicle: $BIKE, $CAR, $BUS or $TRUCK")
        return getCustomerVehicle(readLine())
    }

    /**
     * Checks is [isDiscountAvailable] and returns a discount value for
     * a given vehicle
     *
     * Requirements:
     * - if discount exist, should return a [Fuel.discount] for a corresponding vehicle
     * - if discount isn't exists should return 0
     */
    private fun getDiscountValue(vehicle: Vehicle, isDiscountAvailable: Boolean?): Int {
        TODO()
    }
}