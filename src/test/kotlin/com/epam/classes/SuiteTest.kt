package com.epam.classes

import com.epam.classes.mapper.DiscountAvailabilityMapperTest
import com.epam.classes.mapper.VehicleMapperTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GasStationTest::class,
    VehicleMapperTest::class,
    DiscountAvailabilityMapperTest::class
)
internal class SuiteTest