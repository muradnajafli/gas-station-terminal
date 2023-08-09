package com.epam.classes.mapper

import com.epam.classes.Const
import com.epam.classes.data.*

class DiscountAvailabilityMapper {

    /**
     * Converts user's input into [DiscountAvailability]
     *
     * Requirements for method:
     *  - spaces should be removed
     *  - input should be converted to lower case
     * Requirements for input:
     *  - only not-null and not-empty inputs should be converted
     *
     * @return discount which corresponds to [isAvailable] or [DiscountAvailability.ERROR]
     *         if input doesn't meet requirements
     * @see [Const.YES] [Const.NO]
     */
    fun mapAnswer(isAvailable: String?): DiscountAvailability{
        if (isAvailable != null) {
            val lowerCaseIsAvailable = isAvailable.toLowerCase().trim()
            return when (lowerCaseIsAvailable) {
                Const.YES -> DiscountAvailability.AVAILABLE
                Const.NO -> DiscountAvailability.NON_AVAILABLE
                else -> DiscountAvailability.ERROR
            }
        }
        return DiscountAvailability.ERROR
    }
}