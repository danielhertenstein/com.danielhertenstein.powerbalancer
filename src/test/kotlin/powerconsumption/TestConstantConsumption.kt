package powerconsumption

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestConstantConsumption {
    private lateinit var startDateTime: LocalDateTime
    private lateinit var endDateTime: LocalDateTime
    private lateinit var constantConsumption: ConstantConsumption
    private val hourlyPowerConsumptionRate = 2.0

    @BeforeEach
    fun beforeEach() {
        startDateTime = LocalDateTime.of(2019, 2, 6, 0, 0)
        endDateTime = startDateTime.plusHours(1L)
        constantConsumption = ConstantConsumption(startDateTime, hourlyPowerConsumptionRate)
    }

    @Test
    fun constantConsumptionReturnsItsConstant() {
        val powerConsumed = constantConsumption.powerConsumedForDateTime(endDateTime)
        assertEquals(powerConsumed, hourlyPowerConsumptionRate)
    }

    @Test fun constantConsumptionForOverADayHandledCorrectly() {
        endDateTime = startDateTime.plusHours(25L)
        val powerConsumed = constantConsumption.powerConsumedForDateTime(endDateTime)
        assertEquals(powerConsumed, hourlyPowerConsumptionRate * 25)
    }
}
