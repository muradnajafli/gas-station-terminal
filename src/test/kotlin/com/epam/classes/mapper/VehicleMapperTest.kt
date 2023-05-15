package com.epam.classes.mapper

import com.epam.classes.Const
import com.epam.classes.data.*
import org.junit.Test

class VehicleMapperTest {

    private val mapper = VehicleMapper()
    private val testInput = arrayOf(Const.BIKE, Const.CAR, Const.TRUCK, Const.BUS)

    @Test
    fun `when input is 'bike' then Bike should be created`() {
        val vehicle = mapper.mapNameToVehicle(testInput[0])
        assert(vehicle is Bike)
    }

    @Test
    fun `when input is 'car' then Car should be created`() {
        val vehicle = mapper.mapNameToVehicle(testInput[1])
        assert(vehicle is Car)
    }

    @Test
    fun `when input is 'truck' then Truck should be created`() {
        val vehicle = mapper.mapNameToVehicle(testInput[2])
        assert(vehicle is Truck)
    }

    @Test
    fun `when input is 'bus' then Bus should be created`() {
        val vehicle = mapper.mapNameToVehicle(testInput[3])
        assert(vehicle is Bus)
    }

    @Test
    fun `when input is empty then NonVehicle should be created`() {
        val vehicle = mapper.mapNameToVehicle("")
        assert(vehicle is NonVehicle)
    }

    @Test
    fun `when input is null then NonVehicle should be created`() {
        val vehicle = mapper.mapNameToVehicle(null)
        assert(vehicle is NonVehicle)
    }

    @Test
    fun `when input contains spaces then it should be trimmed`() {
        val inputWihSpaces = "  ${Const.BUS}  "
        val vehicle = mapper.mapNameToVehicle(inputWihSpaces)
        assert(vehicle is Bus){
            "All spaces should be removed, for example: \"  bus  \" -> \"bus\" "
        }
    }

    @Test
    fun `when input contains upper case then toLowerCase should be applied on it`() {
        val inputInUpperCase = Const.BUS.toUpperCase()
        val vehicle = mapper.mapNameToVehicle(inputInUpperCase)
        assert(vehicle is Bus){
            "User input should be converted to lower case, for example: BUS -> bus"
        }
    }
}