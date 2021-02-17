package com.epam.classes.mapper

import com.epam.classes.Const.NO
import com.epam.classes.Const.YES
import com.epam.classes.data.DiscountAvailability

class DiscountAvailabilityMapper {
    /**
     * If 'isDiscountCardAvailable' contains spaces we should remove them.
     * And also case should not affect the result. We must convert 'isDiscountCardAvailable'
     * to lower case
     */
    fun mapAnswer(isDiscountCardAvailable: String?) =
        when (isDiscountCardAvailable) {
            YES -> DiscountAvailability.AVAILABLE
            NO -> DiscountAvailability.NON_AVAILABLE
            else -> DiscountAvailability.ERROR
        }
}