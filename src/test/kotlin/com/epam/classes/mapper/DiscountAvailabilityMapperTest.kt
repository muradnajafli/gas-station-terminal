package com.epam.classes.mapper

import com.epam.classes.Const
import com.epam.classes.data.DiscountAvailability
import org.junit.Test

class DiscountAvailabilityMapperTest {

    private val mapper = DiscountAvailabilityMapper()
    private val testInput = arrayOf(Const.YES, Const.NO)

    @Test
    fun `when input is 'yes' then discount should be AVAILABLE`() {
        val vehicle = mapper.mapAnswer(testInput[0])
        assert(vehicle == DiscountAvailability.AVAILABLE)
    }

    @Test
    fun `when input is 'no' then discount should be NON_AVAILABLE`() {
        val vehicle = mapper.mapAnswer(testInput[1])
        assert(vehicle == DiscountAvailability.NON_AVAILABLE)
    }

    @Test
    fun `when input is null then discount should be ERROR`() {
        val vehicle = mapper.mapAnswer(null)
        assert(vehicle == DiscountAvailability.ERROR)
    }

    @Test
    fun `when input is empty then discount should be ERROR`() {
        val vehicle = mapper.mapAnswer("")
        assert(vehicle == DiscountAvailability.ERROR)
    }

    @Test
    fun `when input contains spaces then then it should be trimmed`() {
        val inputWithSpaces = "  ${Const.YES}  "
        val vehicle = mapper.mapAnswer(inputWithSpaces)
        assert(vehicle == DiscountAvailability.AVAILABLE) {
            "All spaces should be removed, for example: \"  yes  \" -> \"yes\" "
        }
    }

    @Test
    fun `when input contains upper case then toLowerCase should be applied on it`() {
        val inputInUpperCase = Const.YES.toUpperCase()
        val vehicle = mapper.mapAnswer(inputInUpperCase)
        assert(vehicle == DiscountAvailability.AVAILABLE) {
            "User input should be converted to lower case, for example: YES -> yes"
        }
    }
}