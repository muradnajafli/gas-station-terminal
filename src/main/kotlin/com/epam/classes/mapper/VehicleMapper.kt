package com.epam.classes.mapper

import com.epam.classes.data.Bike
import com.epam.classes.data.Bus
import com.epam.classes.data.Car
import com.epam.classes.Const.BIKE
import com.epam.classes.Const.BUS
import com.epam.classes.Const.CAR
import com.epam.classes.Const.TRUCK
import com.epam.classes.data.NonVehicle
import com.epam.classes.data.Truck

class VehicleMapper {

    /**
     * If 'vehicleName' contains spaces we should remove them.
     * And also case should not affect the result. We must convert 'vehicleName'
     * to lower case
     */
    fun mapNameToVehicle(vehicleName: String?) =
        when (vehicleName) {
            BIKE -> Bike()
            CAR -> Car()
            BUS -> Bus()
            TRUCK -> Truck()
            else -> NonVehicle
        }
}