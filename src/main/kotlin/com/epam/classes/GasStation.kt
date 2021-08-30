package com.epam.classes

import com.epam.classes.Const.BIKE
import com.epam.classes.Const.BUS
import com.epam.classes.Const.CAR
import com.epam.classes.Const.NO
import com.epam.classes.Const.TRUCK
import com.epam.classes.Const.YES
import com.epam.classes.data.Vehicle

class GasStation {

    /**
     * Initialize 'vehicleMapper' and 'discountAvailabilityMapper' here
     * and make it private
     */
    val vehicleMapper =
     val discountAvailabilityMapper =

    fun fillTank() {
        val vehicle = selectVehicle()
        val isDiscountExist = isDiscountExist()
        println("How much fuel do you want to fill?")
        checkAndShowTotalPrice(vehicle, isDiscountExist, readLine())
    }

    fun selectVehicle(): Vehicle {
        println("Please choose your vehicle: $BIKE, $CAR, $BUS or $TRUCK")
        return getCustomerVehicle(readLine())
    }

    /**
     * Using 'VehicleMapper' in this function get vehicle instance and
     * then return it after checking.
     * User should see in terminal "Your vehicle is toStringImplementationOfYourVehicleClass"
     * notification after successful choosing a vehicle.
     * In an unsuccessful case (when vehicle is 'com.epam.classes.data.NonVehicle')
     * user should see "Please select one of the available vehicles:
     * bike, car, bus or truck" notification and
     * must enter vehicleName for checking it one more time.
     * @param vehicleName of customer vehicle (one of suggested)
     * @return com.epam.classes.data.Vehicle instance after check
     */
    fun getCustomerVehicle(vehicleName: String?): Vehicle {
        TODO()
    }

    private fun isDiscountExist(): Boolean? {
        println("Do you have a discount card? ($YES or $NO)")
        return checkAndReturnIsDiscountAvailable(readLine())
    }

    /**
     * Using 'DiscountAvailabilityMapper' get 'DiscountAvailability' and then
     * use 'when' expression to return correct Boolean value regarding 'DiscountAvailability'.
     * User should see "Discount exist" notification after
     * accepting discount availability. User should see "Discount doesn't exist"
     * notification after declining discount availability.
     * In an unsuccessful case user should see "Please enter "yes" or "no"" notification and should
     * enter discount availability one more time. Instead of “yes” and “no” use const strings.
     * You should handle cases when value that you are getting from the terminal is NOT null only.
     * @param answerAboutDiscount string, which must be "yes" or "no", in other cases
     * app should propose to user to enter answer about discount availability one more time
     * @return boolean value. If a user has a discount, the app should return "true",
     * if they don't have - "false".
     */
    fun checkAndReturnIsDiscountAvailable(answerAboutDiscount: String?): Boolean? {
        //TODO()
    }

    /**
     * @param volumeString string, amount of liters that customers want to fill
     * @param vehicle - vehicle that we need to fill
     * @param isDiscountExist - boolean value that we can receive after executing
     * 'isDiscountExist'
     * @return Unit
     * Handle these cases and ask user to enter amount of liters one more time:
     * 1) volume contains incorrect value that cannot be cast to Int
     * 2) volume contains amount of liters that more than vehicle tank volume
     *
     * As a result of this fun user will see next notification:
     * a) Successful case: "Bill: $totalPrice". Total price we can
     * calculate using 'calculateTotalPrice' function
     * b) Unsuccessful case: "Please enter correct value (not
     * bigger than your tank volume: 500 liters)" where 500 is volume of vehicle tank.
     * After appearing of this message user should enter volume value one more time.
     * You should handle cases when value that you are getting from the terminal is NOT null only.
     */
    fun checkAndShowTotalPrice(vehicle: Vehicle, isDiscountExist: Boolean?, volumeString: String?) {
        //TODO()
    }

    /**
     * For the calculation of total price you should multiply the number of liters by
     * the cost per liter with discount. Please keep in mind that `discount` value of
     * Fuel instance set in percentages. For example, if discount value is 5,
     * it means that discount is 5%.
     * @param fuelValue Int, number of liters that customers want to fill
     * @param vehicle - vehicle that we need to fill
     * @param isDiscountExist - boolean value that we can receive after executing
     * 'isDiscountExist' function
     * @return totalPrice - Double
     */
    fun calculateTotalPrice(fuelValue: Int, vehicle: Vehicle, isDiscountExist: Boolean?): Double {
        //TODO()
    }

    private fun getDiscountValue(vehicle: Vehicle, isDiscountCardAvailable: Boolean?) =
        if (isDiscountCardAvailable == true) {
            vehicle.fuel.discountValue
        } else {
            0
        }
}