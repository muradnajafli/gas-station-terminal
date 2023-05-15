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

    @After
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `when Bike is selected then appropriate message should be shown`() {
        val input = BIKE
        gasStation.getCustomerVehicle(input)
        Assert.assertEquals(
            "Your vehicle is ${Bike::class.simpleName}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when Bus is selected then appropriate message should be shown`() {
        val input = BUS
        gasStation.getCustomerVehicle(input)
        Assert.assertEquals(
            "Your vehicle is ${Bus::class.simpleName}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when Car is selected then appropriate message should be shown`() {
        val input = CAR
        gasStation.getCustomerVehicle(input)
        Assert.assertEquals(
            "Your vehicle is ${Car::class.simpleName}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when Truck is selected then appropriate message should be shown`() {
        val input = TRUCK
        gasStation.getCustomerVehicle(input)
        Assert.assertEquals(
            "Your vehicle is ${Truck::class.simpleName}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when user input is not valid for vehicle then an error notification should be shown`() {
        val vehicle = "vehicle"
        gasStation.getCustomerVehicle(vehicle)
        Assert.assertEquals(
            "Please select one of available vehicles: $BIKE, $CAR, $BUS or $TRUCK",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when discount is available then appropriate message should be shown`() {
        gasStation.checkAndReturnIsDiscountAvailable(YES)
        Assert.assertEquals(
            "Discount exist",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when discount is not available then appropriate message should be shown`() {
        gasStation.checkAndReturnIsDiscountAvailable(NO)
        Assert.assertEquals(
            "Discount doesn't exist",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when user input is not valid for discount then an error notification should be shown`() {
        gasStation.checkAndReturnIsDiscountAvailable("not valid input")
        Assert.assertEquals(
            "Please enter \"$YES\" or \"$NO\"",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when discount exists then it should be applied to the total price`() {
        val amount = 100
        val vehicle = Bus()
        /*
           Formula to calculate: amount * (costPerLiter - costPerLiter*discount)
           Since bus uses diesel (2$ pet liter and discount 5%) we have:
           100 * (2 - 2 * 0.05) = 100 * (2-0.1) = 190
         */
        val expectedPrice = 190.0

        val totalPrice = gasStation.calculateTotalPrice(amount, vehicle, true)
        assert(expectedPrice == totalPrice) {
            "For example: for 100 liters of diesel (2 dollars pet liter and discount 5%) " +
                    "total price should be 190 "
        }
    }

    @Test
    fun `when bill is ready for Bus then appropriate message should be shown`() {
        val volume = "20"
        val fuelValue = volume.toInt()
        val vehicle = Bus()
        val isDiscountExist = false

        val totalPrice = gasStation.calculateTotalPrice(fuelValue, vehicle, isDiscountExist)
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)

        Assert.assertEquals(
            "Bill: $totalPrice",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when bill is ready for Car then appropriate message should be shown`() {
        val volume = "20"
        val fuelValue = volume.toInt()
        val vehicle = Car()
        val isDiscountExist = false

        val totalPrice = gasStation.calculateTotalPrice(fuelValue, vehicle, isDiscountExist)
        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)

        Assert.assertEquals(
            "Bill: $totalPrice",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when bill is ready for Bike then appropriate message should be shown`() {
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
    fun `when bill is ready for Truck then appropriate message should be shown`() {
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
    fun `when liters amount are greater than vehicle tank volume then error notification should be shown`() {
        val volume = "2000"
        val vehicle = Car()
        val isDiscountExist = true

        gasStation.checkAndShowTotalPrice(vehicle, isDiscountExist, volume)

        Assert.assertEquals(
            "Please enter correct value (not bigger than your tank volume: ${vehicle.volume} liters)",
            outputStreamCaptor.toString().trim()
        )
    }
}