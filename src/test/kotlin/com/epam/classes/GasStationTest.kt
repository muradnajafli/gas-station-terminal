package com.epam.classes

import com.epam.classes.Const.BIKE
import com.epam.classes.Const.BUS
import com.epam.classes.Const.CAR
import com.epam.classes.Const.NO
import com.epam.classes.Const.TRUCK
import com.epam.classes.Const.YES
import com.epam.classes.data.*
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
    fun `when vehicle is selected and discount availability is defined then appropriate message should be shown`() {
        gasStation.fillTank()
        assert(outputStreamCaptor.toString().trim().contains("How much fuel do you want to fill?"))
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
        val bill = Bill(
            vehicle = Bus(),
            isDiscountExist = true,
            amountToFill = 100,
            totalPrice = 0.0
        )


        val expectedTotalPrice = 190.0

        val totalBill = gasStation.calculateTotalPrice(bill)
        assert(expectedTotalPrice == totalBill.totalPrice) {
            "For example: for 100 liters of diesel (2 dollars pet liter and discount 5%) " +
                    "total price should be 190, but was ${totalBill.totalPrice} "
        }
    }

    @Test
    fun `when total price is calculated for Bus then it should be added to the bill`() {
        val volume = "20"
        val bill = Bill(
            vehicle = Bus(),
            isDiscountExist = false,
            amountToFill = volume.toInt(),
            totalPrice = 0.0
        )

        gasStation.checkAndShowTotalInfo(bill, volume)

        Assert.assertEquals(
            "Total info: ${bill.copy(totalPrice = 40.0)}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when total price is calculated for Card then it should be added to the bill`() {
        val volume = "20"
        val bill = Bill(
            vehicle = Car(),
            isDiscountExist = false,
            amountToFill = volume.toInt(),
            totalPrice = 0.0
        )

        gasStation.checkAndShowTotalInfo(bill, volume)

        Assert.assertEquals(
            "Total info: ${bill.copy(totalPrice = 60.0)}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when total price is calculated for Bike then it should be added to the bill`() {
        val volume = "10"
        val bill = Bill(
            vehicle = Bike(),
            isDiscountExist = false,
            amountToFill = volume.toInt(),
            totalPrice = 0.0
        )

        gasStation.checkAndShowTotalInfo(bill, volume)

        Assert.assertEquals(
            "Total info: ${bill.copy(totalPrice = 30.0)}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when total price is calculated for Truck then it should be added to the bill`() {
        val volume = "20"
        val bill = Bill(
            vehicle = Truck(),
            isDiscountExist = true,
            amountToFill = volume.toInt(),
            totalPrice = 0.0
        )
        gasStation.checkAndShowTotalInfo(bill, volume)

        Assert.assertEquals(
            "Total info: ${bill.copy(totalPrice = 38.0)}",
            outputStreamCaptor.toString().trim()
        )
    }

    @Test
    fun `when liters amount are greater than vehicle tank volume then error notification should be shown`() {
        val volume = "2000"
        val bill = Bill(
            vehicle = Car(),
            isDiscountExist = true,
            amountToFill = volume.toInt(),
            totalPrice = 0.0
        )

        gasStation.checkAndShowTotalInfo(bill, volume)

        Assert.assertEquals(
            "Please enter correct value (not bigger than your tank volume: ${bill.vehicle.volume} liters)",
            outputStreamCaptor.toString().trim()
        )
    }
}