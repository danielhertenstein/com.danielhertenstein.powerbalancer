package powerconsumption

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestRealConsumption {

    @Test
    fun realConsumptionReadsFromSensor() {
        val startDateTime = LocalDateTime.of(2019, 2, 6, 0, 0)
        val endDateTime = startDateTime.plusHours(1L)
        val consumption = RealConsumption(startDateTime)
        val powerConsumed = consumption.powerConsumedForDateTime(endDateTime)
        assertEquals(powerConsumed, 999.9)
    }
}