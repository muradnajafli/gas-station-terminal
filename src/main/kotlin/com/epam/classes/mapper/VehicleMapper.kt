package com.epam.classes.mapper

import com.epam.classes.Const
import com.epam.classes.data.*

class VehicleMapper {

    /**
     * Converts user's input into [Vehicle].
     *
     * Requirements for method:
     *  - spaces should be removed
     *  - input should be converted to lower case
     * Requirements for input:
     *  - only not-null and not-empty inputs should be converted
     *
     * @return vehicle which corresponds to [vehicleName] or [NonVehicle]
     *         if input doesn't meet requirements
     * @see [Const.BUS] [Const.TRUCK] [Const.CAR] [Const.BIKE]
     */
    fun mapNameToVehicle(vehicleName: String?): Vehicle {
        if (vehicleName != null) {
            val lowerCaseVehicleName = vehicleName.toLowerCase().trim()
            return when (lowerCaseVehicleName) {
                Const.BUS -> Bus()
                Const.TRUCK -> Truck()
                Const.CAR -> Car()
                Const.BIKE -> Bike()
                else -> NonVehicle
            }
        }
        return NonVehicle
    }
}