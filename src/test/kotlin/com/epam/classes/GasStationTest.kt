package com.epam.classes

import com.epam.classes.Const.BIKE
import com.epam.classes.Const.BUS
import com.epam.classes.Const.CAR
import com.epam.classes.Const.NO
import com.epam.classes.Const.TRUCK
import com.epam.classes.Const.YES
import com.epam.classes.data.Bike
import com.epam.classes.data.Bus
import com.epam.classes.data.Car
import com.epam.classes.data.Truck
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class GasStationTest {

    private lateinit var gasStation: GasStation

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @Before
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
        gasStation = GasStation()
    }

    @Test
    fun testCheckAndReturnBike() {
        val bike = BIKE
        val vehicle = gasStation.getCustomerVehicle(bike)
        Assert.assertEquals(
            "Your vehicle is $vehicle",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnBus() {
        val bus = BUS
        val vehicle = gasStation.getCustomerVehicle(bus)
        Assert.assertEquals(
            "Your vehicle is $vehicle",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnCar() {
        val car = CAR
        val vehicle = gasStation.getCustomerVehicle(car)
        Assert.assertEquals(
            "Your vehicle is $vehicle",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnTruck() {
        val truck = TRUCK
        val vehicle  = gasStation.getCustomerVehicle(truck)
        Assert.assertEquals(
            "Your vehicle is $vehicle",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnIncorrectVehicle() {
        val vehicle = "vehicle"
        gasStation.getCustomerVehicle(vehicle)
        Assert.assertEquals(
            "Please select one of available vehicles: $BIKE, $CAR, $BUS or $TRUCK",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnDiscountAvailable() {
        val isDiscountCardAvailable = YES
        gasStation.checkAndReturnIsDiscountAvailable(isDiscountCardAvailable)
        Assert.assertEquals(
            "Discount exist",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnDiscountNotAvailable() {
        val isDiscountCardAvailable = NO
        gasStation.checkAndReturnIsDiscountAvailable(isDiscountCardAvailable)
        Assert.assertEquals(
            "Discount doesn't exist",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckAndReturnDiscountAvailabilityError() {
        val isDiscountCardAvailable = "test"
        gasStation.checkAndReturnIsDiscountAvailable(isDiscountCardAvailable)
        Assert.assertEquals(
            "Please enter \"$YES\" or \"$NO\"",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckFuelVolumeForBus() {
        val volume = "20"
        val fuelValue = volume.toInt()
        val vehicle = Bus()
        val isDiscountExist = true
        val totalPrice = gasStation.calculateTotalPrice(fuelValue, vehicle, isDiscountExist)
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)
        Assert.assertEquals(
            "Bill: $totalPrice",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckFuelVolumeForCar() {
        val volume = "20"
        val fuelValue = volume.toInt()
        val vehicle = Car()
        val isDiscountExist = true
        val totalPrice = gasStation.calculateTotalPrice(fuelValue, vehicle, isDiscountExist)
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)
        Assert.assertEquals(
            "Bill: $totalPrice",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckFuelVolumeForBike() {
        val volume = "10"
        val fuelValue = volume.toInt()
        val vehicle = Bike()
        val isDiscountExist = true
        val totalPrice = gasStation.calculateTotalPrice(fuelValue, vehicle, isDiscountExist)
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)
        Assert.assertEquals(
            "Bill: $totalPrice",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckFuelVolumeForTruck() {
        val volume = "20"
        val fuelValue = volume.toInt()
        val vehicle = Truck()
        val isDiscountExist = true
        val totalPrice = gasStation.calculateTotalPrice(fuelValue, vehicle, isDiscountExist)
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)
        Assert.assertEquals(
            "Bill: $totalPrice",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun testCheckFuelIncorrectVolumeForCar() {
        val volume = "2000"
        val vehicle = Car()
        val isDiscountExist = true
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)
        Assert.assertEquals(
            "Please enter correct value (not bigger than your tank volume: ${vehicle.volume} liters)",
            outputStreamCaptor.toString().trim()
        )
    }

    @After
    fun tearDown() {
        System.setOut(standardOut)
    }
}